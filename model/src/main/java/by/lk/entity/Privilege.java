package by.lk.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Vinty on 21.04.2017.
 */
@Entity
@Table(name = "privileges")
@ToString
@NoArgsConstructor
public class Privilege extends BaseEntity {
    @Setter
    @Getter
    @Column(name = "name")
    private String namePrivilege;
}
