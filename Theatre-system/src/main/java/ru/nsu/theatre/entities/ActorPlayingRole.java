package ru.nsu.theatre.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.nsu.theatre.entities.HelpForNormForm.ActorRoleId;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "actor_playing_role")
public class ActorPlayingRole {
    @EmbeddedId
    private ActorRoleId id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_ActorPlayingRole_Role"), insertable = false, updatable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "actor_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_ActorPlayingRole_Actor"), insertable = false, updatable = false)
    private Actor actor;

    @Column(name = "is_main")
    private Boolean main;

    @Column(name = "date_of_playing")
    private Date date;
}
