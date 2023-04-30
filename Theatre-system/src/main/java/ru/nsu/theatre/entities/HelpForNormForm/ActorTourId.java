package ru.nsu.theatre.entities.HelpForNormForm;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Getter
@Setter
@Embeddable
public class ActorTourId implements Serializable {

    @Column(name = "actor_id")
    private Long actorId;

    @Column(name = "date_of_tour_id")
    private Long roleId;
}