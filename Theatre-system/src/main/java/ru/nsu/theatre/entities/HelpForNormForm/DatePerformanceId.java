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
public class DatePerformanceId implements Serializable {

    @Column(name = "date_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long dateId;

    @Column(name = "performance_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long performanceId;
}