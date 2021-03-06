package xmu.crms;

import com.fasterxml.jackson.databind.ObjectMapper;
import xmu.crms.dto.SchoolDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 
 * @author zimu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SchoolControllerTest {
	@Autowired
	private MockMvc mvc;

	/**
	 * 获取学校列表，成功返回200
	 * @throws Exception
	 */
	@Test
	public void testGetSchoolList() throws Exception{
		mvc.perform(get("/school?city={city}","福建"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].id").isNumber())
			.andExpect(jsonPath("$[0].name").isString())
			.andExpect(jsonPath("$[0].province").isString())
			.andExpect(jsonPath("$[0].city").isString());
	}
	
	/**
	 * 添加学校，成功返回201
	 * @throws Exception
	 */
	@Test
	public void testAddSchool() throws Exception{

		ObjectMapper mapper = new ObjectMapper();

		SchoolDTO dto = new SchoolDTO();
		dto.setCity("厦门");
		dto.setName("厦门市人民公园");
		dto.setProvince("福建");

		mvc.perform(post("/school")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsString(dto)))
					.andExpect(status().isCreated());
		
	}
	
	/**
	 * 获取省份列表，成功返回200
	 * @throws Exception
	 */
	@Test
	public void testGetProvinceList() throws Exception{
		mvc.perform(get("/school/province"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0]").isString());
	}
	
	/**
	 * 获取城市列表，成功返回200
	 * @throws Exception
	 */
	@Test
	public void testGetCityList() throws Exception{
		mvc.perform(get("/school/city?province={province}","河北省"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0]").isString());
	}
}
