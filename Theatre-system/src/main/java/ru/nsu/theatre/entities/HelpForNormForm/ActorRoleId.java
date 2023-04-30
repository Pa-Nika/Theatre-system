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
public class ActorRoleId implements Serializable {

    @Column(name = "actor_id")
    private Long actorId;

    @Column(name = "role_id")
    private Long roleId;
}