package ru.nsu.theatre.entities.HelpForNormForm;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class DirectorPerformanceId implements Serializable {

    @Column(name = "director_id")
    private Long directorId;

    @Column(name = "performance_id")
    private Long performanceId;
}