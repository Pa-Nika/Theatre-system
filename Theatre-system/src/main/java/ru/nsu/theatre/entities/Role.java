package ru.nsu.theatre.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Data
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    @GenericGenerator(name = "pet_seq", strategy = "increment")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "is_main")
    private Boolean main;

    @Column(name = "age")
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @Column(name = "height")
    private Integer height;

    @OneToOne
    private Performance performance;

    public Role(String name, Boolean main, Integer age, Gender gender, Integer height, Performance performance) {
        this.name = name;
        this.main = main;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.performance = performance;
    }

    public Role() {
    }
}
