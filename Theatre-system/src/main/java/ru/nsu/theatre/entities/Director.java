package ru.nsu.theatre.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "Director")
public class Director {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "employee_id")
    private Integer employee_id;
}