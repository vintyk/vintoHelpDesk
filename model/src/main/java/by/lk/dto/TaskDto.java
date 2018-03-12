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
//    private String nameTypeOfJobId;
    private Long systemUser;
    private Long operatorId;
    private Long executorId;

    public TaskDto(Long id,
                   String name,
                   String text,
                   Long typeOfJobId,
//                   String nameTypeOfJobId,
                   Long systemUser,
                   Long operatorId,
                   Long executorId) {
        super(id);
        this.name = name;
        this.text = text;
        this.typeOfJobId = typeOfJobId;
//        this.nameTypeOfJobId = nameTypeOfJobId;
        this.systemUser = systemUser;
        this.operatorId = operatorId;
        this.executorId = executorId;
    }
}
