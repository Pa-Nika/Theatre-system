package ru.nsu.theatre.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.Duration;
import java.time.Period;

@Data
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

//    @Column(name = "type_id")
    @ManyToOne
    @JoinColumn(name = "type_id")
    private EmployeeType type_id;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "name")
    private String name;

    @Column(name = "gender_id")
    private Integer gender;

//    @Column(name = "age")
//    private Period age;
}
