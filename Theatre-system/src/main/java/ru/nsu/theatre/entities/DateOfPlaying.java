package ru.nsu.theatre.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Data
@Getter
@Setter
@Entity
@Table(name = "date_of_playing")
public class DateOfPlaying {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "date_of_performance")
    private Date date_of_birth;

    @Column(name = "season")
    private Double season;

    @Column(name = "count_of_tickets")
    private Short ticketsCount;

    @Column(name = "is_tour")
    private Boolean isTour;

}