package ru.nsu.theatre.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.nsu.theatre.entities.HelpForNormForm.TicketPlaceId;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "ticket_place")
public class TicketPlace {
    @EmbeddedId
    private TicketPlaceId id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "ticket_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_TicketPlace_Ticket"), insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_TicketPlace_Place"), insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Place place;
}
