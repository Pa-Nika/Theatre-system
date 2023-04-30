package ru.nsu.theatre.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Getter
@Setter
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    @GenericGenerator(name = "pet_seq", strategy = "increment")
    private Long id;

    @Column(name = "is_preliminarily_sold")
    private Boolean isSold;

    @Column(name = "price")
    private Short price;

    @ManyToOne
    @JoinColumn(name = "performance_id")
    private Performance performance;

    @ManyToOne
    @JoinColumn(name = "date_id")
    private DateOfPlaying date;
}
