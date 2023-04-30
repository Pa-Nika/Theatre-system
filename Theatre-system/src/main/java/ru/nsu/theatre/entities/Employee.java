package ru.nsu.theatre.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;

@Data
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    @GenericGenerator(name = "pet_seq", strategy = "increment")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private EmployeeType type;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "user_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private Director director;

}
