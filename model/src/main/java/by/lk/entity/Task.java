package by.lk.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
//@Table(name = "task")
@ToString
@NoArgsConstructor
@Setter
@Getter
public class Task extends BaseEntity {
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "type_of_job_id")
    private TypeOfJobs typeOfJobId;
    @Column(name = "text")
    private String text;
    @ManyToOne
    @JoinColumn(name = "system_user_id")
    private SystemUser systemUser;
    @ManyToOne
    @JoinColumn(name = "operator_id")
    private SystemUser operator;
    @ManyToOne
    @JoinColumn(name = "executor_id")
    private SystemUser executor;
}
