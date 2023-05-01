package ru.nsu.theatre.entities;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "type_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private EmployeeType type;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "user_name")
    private String name;

    @Column(name = "start_work_date")
    private LocalDate work;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "children_count")
    private Integer children;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "gender_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Gender gender;

    @Transient
    private Period age;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private Director director;

    public Employee(EmployeeType type, LocalDate dateOfBirth, String name, LocalDate work, Integer salary, Integer children, Gender gender) {
        this.type = type;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.work = work;
        this.salary = salary;
        this.children = children;
        this.gender = gender;
    }

    public Employee() {
    }

    public String calculateAge() {
        LocalDate birthDate = this.dateOfBirth;
        LocalDate currentDate = LocalDate.now();
        Integer years = Period.between(birthDate, currentDate).getYears();
        return years + " лет";
    }

    public String getNormDateOfBirth() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return this.dateOfBirth.format(formatter);
    }

    public String getNormDateStartWork() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return this.work.format(formatter);
    }
}
