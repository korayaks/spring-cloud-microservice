package com.korayaks.ticketservice.service;

import com.korayaks.ticketservice.dto.TicketDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {
    TicketDto save(TicketDto ticketDto);
    TicketDto update(String id, TicketDto ticketDto);
    TicketDto getById(String id);
    Page<TicketDto> getPagination(Pageable ticketDto);
}
