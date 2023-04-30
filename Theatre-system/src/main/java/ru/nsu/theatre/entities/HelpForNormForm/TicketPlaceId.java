package ru.nsu.theatre.entities.HelpForNormForm;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Getter
@Setter
@Embeddable
public class TicketPlaceId implements Serializable {

    @Column(name = "ticket_id")
    private Long ticketId;

    @Column(name = "place_id")
    private Long placeId;
}