package com.korayaks.ticketservice.service.Impl;

import com.korayaks.ticketservice.dto.TicketDto;
import com.korayaks.ticketservice.service.TicketService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class TicketServiceImpl implements TicketService {

    @Override
    public TicketDto save(TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto update(String id, TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getById(String id) {
        return null;
    }

    @Override
    public Page<TicketDto> getPagination(Pageable ticketDto) {
        return null;
    }
}
