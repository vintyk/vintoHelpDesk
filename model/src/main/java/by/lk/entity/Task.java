package by.lk.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "task")
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
    @JoinColumn(name = "branch_id")
    private Branch branch;
    @ManyToOne
    @JoinColumn(name = "subdivision_id")
    private Subdivision subdivision;
    @ManyToOne
    @JoinColumn(name = "system_user_id")
    private SystemUser systemUser;
}
