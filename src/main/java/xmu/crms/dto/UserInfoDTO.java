package xmu.crms.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

/**
 *
 * @author status200
 * @date 2017/11/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoDTO {

    private BigInteger id;
    private String type;
    private String name;
    private String phone;
    private String number;
    private String email;
    private String gender;
    private String title;
    private String avatar;
    private SchoolDTO school;
    private String password;
    private String unionID;
}
