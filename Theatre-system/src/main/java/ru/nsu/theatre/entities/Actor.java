package ru.nsu.theatre.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employee employee;

    @Column(name = "height")
    private Integer height;

    @Column(name = "is_student")
    private Boolean student;
}