package ru.nsu.theatre.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

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
    private LocalDate dateOfBirth;

    @Column(name = "user_name")
    private String name;

    @Column(name = "start_work_date")
    private Date work;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "children_count")
    private Integer children;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @Transient
    private Period age;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private Director director;

    public String calculateAge() {
        LocalDate birthDate = this.dateOfBirth;
        LocalDate currentDate = LocalDate.now();
        Integer years = Period.between(birthDate, currentDate).getYears();
        return years + " лет";
    }

    public String getNormDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return this.dateOfBirth.format(formatter);
    }

}
