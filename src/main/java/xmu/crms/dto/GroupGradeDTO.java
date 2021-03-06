package xmu.crms.dto;

import xmu.crms.vo.PresentationGradeVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @author status200
 * @date 2017/12/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupGradeDTO {

    private List<PresentationGradeVO> presentationGrade;
}
