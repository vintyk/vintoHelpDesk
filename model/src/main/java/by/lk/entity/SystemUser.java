package by.lk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "system_user")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class SystemUser extends BaseEntity {
    @Column(name = "name")
    private String nameUser;

    @Column(name = "family")
    private String familyUser;

    @NotEmpty
    @Column(name = "e_mail", nullable = false)
    private String email;

    @NotEmpty
    @Column(name = "password", nullable = false)
    private String passwordUser;


    @ManyToOne
    @JoinColumn(name = "privilege_id")
    private Privilege privilege;
}
