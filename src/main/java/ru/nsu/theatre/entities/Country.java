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
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    @GenericGenerator(name = "pet_seq", strategy = "increment")
    private Long id;

    @Column(name = "country")
    private String country;
}
