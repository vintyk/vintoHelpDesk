package by.lk.entity;

<<<<<<< HEAD
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
=======
import javax.persistence.Entity;
import javax.persistence.*;
>>>>>>> 2 базовых класса


@Entity
@Table(name = "system_user")
<<<<<<< HEAD
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
=======
public class SystemUser extends BaseEntity{

>>>>>>> 2 базовых класса
}
