package ru.nsu.theatre.entities.HelpForNormForm;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@Embeddable
public class TicketPlaceId implements Serializable {

    @Column(name = "ticket_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long ticketId;

    @Column(name = "place_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long placeId;
}