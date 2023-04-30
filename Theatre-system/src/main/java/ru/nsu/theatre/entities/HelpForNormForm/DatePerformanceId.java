package ru.nsu.theatre.entities.HelpForNormForm;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class DatePerformanceId implements Serializable {

    @Column(name = "date_id")
    private Long dateId;

    @Column(name = "performance_id")
    private Long performanceId;
}