package ru.nsu.theatre.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Getter
@Setter
@Entity
@Table(name = "author")
public class Author {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    @GenericGenerator(name = "pet_seq", strategy = "increment")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "user_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Column(name = "title")
    private String title;

    public String getNormDateOfBirth() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return this.dateOfBirth.format(formatter);
    }

    public Author(Country country, LocalDate dateOfBirth, String name, Genre genre, String title) {
        this.country = country;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.genre = genre;
        this.title = title;
    }

    public Author() {
    }
}
