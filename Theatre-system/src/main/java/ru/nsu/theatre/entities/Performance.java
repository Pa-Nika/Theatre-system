package ru.nsu.theatre.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "age_limit")
    private Integer limit;

    @Column(name = "premiere_date")
    private Date premiere;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "author_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;

//    @Size(min = 2, max = 255)
    @Column(name = "time_duration", precision = 3, scale = 0)
    private String time;

//    @OneToMany(mappedBy = "performance", cascade = CascadeType.REMOVE)
//    private Set<DirectorPerformance> directorPerformances = new HashSet<>();

}