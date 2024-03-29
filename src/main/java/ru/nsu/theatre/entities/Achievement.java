package ru.nsu.theatre.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
@Table(name = "achievement")
public class Achievement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "date_of_competition")
    private Date dateCompetition;

    @Column(name = "title")
    private String title;

    @OneToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;
}