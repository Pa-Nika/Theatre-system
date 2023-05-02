package ru.nsu.theatre.entities;

import lombok.AllArgsConstructor;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@Table(name = "performance")
public class Performance {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    @GenericGenerator(name = "pet_seq", strategy = "increment")
    private Long id;

    @Column(name = "age_limit")
    private Integer limit;

    @Column(name = "premiere_date")
    private LocalDate premiere;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "author_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;

    @Column(name = "time_duration", precision = 3, scale = 0)
    private Integer time;

    @OneToMany(mappedBy = "performance", cascade = CascadeType.REMOVE)
    private List<DirectorPerformance> director;

    @OneToMany(mappedBy = "performance", cascade = CascadeType.REMOVE)
    private List<DatePerformance> performance;

    public String getNormAge() {
        return limit+"+";
    }

    public String getNormDatePremiere() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return this.premiere.format(formatter);
    }

    public Performance(Integer limit, LocalDate premiere, Author author, Integer time) {
        this.limit = limit;
        this.premiere = premiere;
        this.author = author;
        this.time = time;
    }

    public Performance() {
    }
}