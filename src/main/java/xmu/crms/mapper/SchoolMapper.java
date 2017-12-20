package xmu.crms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.crms.entity.School;

import java.math.BigInteger;
import java.util.List;

/**
 * School Mapper
 * 注意，每个mapper要给其加上一个@Mapper的注解。
 * 且每个mapper都是接口，实现是由mybatis做的,不需要我们实现。
 *
 *
 * @author liuxin
 * @date 2017/12/19
 */
@Mapper
@Component
public interface SchoolMapper {

    /**
     * 列出当前城市下的学校
     * @param city
     * @return
     */
    List<School> listSchoolByCity(@Param("city") String city);

    /**
     * 插入学校
     * @param school
     * @return
     */
    boolean insertSchool(@Param("school") School school);

    /**
     * 根据学校ID获取学校
     * @param schoolId
     * @return
     */
    School getSchoolBySchoolId(BigInteger schoolId);
}
