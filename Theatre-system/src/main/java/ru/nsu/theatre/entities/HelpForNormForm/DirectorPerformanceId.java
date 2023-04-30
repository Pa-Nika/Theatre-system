package ru.nsu.theatre.entities.HelpForNormForm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
//@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class DirectorPerformanceId implements Serializable {

    @Column(name = "director_id")
    private Long directorId;

    @Column(name = "performance_id")
    private Long performanceId;

    // конструкторы, геттеры и сеттеры
}