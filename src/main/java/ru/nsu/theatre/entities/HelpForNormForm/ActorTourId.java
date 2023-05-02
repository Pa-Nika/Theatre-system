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
public class ActorTourId implements Serializable {

    @Column(name = "actor_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long actorId;

    @Column(name = "date_of_tour_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long roleId;
}