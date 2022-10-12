package com.korayaks.ticketservice.service.Impl;

import com.korayaks.messaging.TicketNotification;
import com.korayaks.ticketservice.model.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
@RequiredArgsConstructor
public class TicketNotificationService implements com.korayaks.ticketservice.service.TicketNotificationService {
    private final Source source;

    @Override
    public void sendToQueue(Ticket ticket) {
        TicketNotification ticketNotification = new TicketNotification();
        ticketNotification.setAccountId(ticket.getAssignee());
        ticketNotification.setTicketId(ticket.getId());
        ticketNotification.setTicketDescription(ticket.getDescription());
        source.output().send(MessageBuilder.withPayload(ticketNotification).build());
    }
}
