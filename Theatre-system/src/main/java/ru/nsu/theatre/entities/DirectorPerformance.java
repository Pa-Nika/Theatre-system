package ru.nsu.theatre.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.nsu.theatre.entities.HelpForNormForm.DirectorPerformanceId;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "Director_Performance")
public class DirectorPerformance {
    @EmbeddedId
    private DirectorPerformanceId id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "director_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_DirectorPerformance_Director"), insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Director director;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_DirectorPerformance_Performance"), insertable = false, updatable = false)
    private Performance performance;

}
