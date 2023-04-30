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
@Table(name = "date_of_tour")
public class DateOfTour {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "date_start")
    private Date date_start;

    @Column(name = "date_end")
    private Date date_end;

    @ManyToOne
    @JoinColumn(name = "performance_id")
    private Performance performance;
}