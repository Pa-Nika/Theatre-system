package ru.nsu.theatre.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.nsu.theatre.entities.HelpForNormForm.ActorRoleId;
import ru.nsu.theatre.entities.HelpForNormForm.ActorTourId;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "actor_tour")
public class ActorTour {
    @EmbeddedId
    private ActorTourId id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "date_of_tour_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_ActorTour_DateOfTour"), insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DateOfTour date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_ActorTour_Actor"), insertable = false, updatable = false)
    private Actor actor;
}
