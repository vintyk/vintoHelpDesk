package by.lk.dto;

import by.lk.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Setter
@Getter
public class TaskDto extends BaseEntity {
    private String name;
    private String text;
    private Long typeOfJobId;
    private String nameTypeOfJobId;
    private Long branchId;
    private String branchName;
    private Long subdivisionId;
    private String subdivisionName;
    private Long systemUser;
}
