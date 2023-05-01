package ru.nsu.theatre.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;


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

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "performance_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Performance performance;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "date_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DateOfPlaying date;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.REMOVE)
    private List<TicketPlace> place;
}
