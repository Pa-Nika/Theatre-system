package ru.nsu.theatre.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Table(name = "date_of_playing")
public class DateOfPlaying {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    @GenericGenerator(name = "pet_seq", strategy = "increment")
    private Long id;

    @Column(name = "date_of_performance")
    private Date date_of_birth;

    @Column(name = "season")
    private Integer season;

    @Column(name = "count_of_tickets")
    private Short ticketsCount;

    @Column(name = "is_tour")
    private Boolean isTour;

    @OneToMany(mappedBy = "date", cascade = CascadeType.REMOVE)
    private List<DatePerformance> date;
}