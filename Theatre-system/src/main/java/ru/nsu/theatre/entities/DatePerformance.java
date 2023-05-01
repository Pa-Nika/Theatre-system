package ru.nsu.theatre.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.nsu.theatre.entities.HelpForNormForm.DatePerformanceId;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "date_performance")
public class DatePerformance {
    @EmbeddedId
    private DatePerformanceId id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "date_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_DatePerformance_Date"), insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DateOfPlaying date;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "performance_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_DatePerformance_Performance"), insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Performance performance;
}
