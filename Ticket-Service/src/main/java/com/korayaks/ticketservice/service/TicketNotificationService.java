package com.korayaks.ticketservice.service;

import com.korayaks.ticketservice.model.Ticket;

public interface TicketNotificationService {
    void sendToQueue(Ticket ticket);
}
