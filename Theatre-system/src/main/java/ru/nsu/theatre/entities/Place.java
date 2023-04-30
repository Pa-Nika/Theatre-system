package ru.nsu.theatre.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Getter
@Setter
@Entity
@Table(name = "place")
public class Place {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    @GenericGenerator(name = "pet_seq", strategy = "increment")
    private Long id;

    @Column(name = "number")
    private BigDecimal number;

}
