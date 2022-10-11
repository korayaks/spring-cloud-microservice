package com.korayaks.ticketservice.service.Impl;

import com.korayaks.ticketservice.dto.TicketDto;
import com.korayaks.ticketservice.model.PriorityType;
import com.korayaks.ticketservice.model.Ticket;
import com.korayaks.ticketservice.model.TicketStatus;
import com.korayaks.ticketservice.model.elasticsearch.TicketModel;
import com.korayaks.ticketservice.repository.TicketRepository;
import com.korayaks.ticketservice.repository.elasticsearch.TicketElasticRepository;
import com.korayaks.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketElasticRepository ticketElasticRepository;
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;
    @Override
    @Transactional
    public TicketDto save(TicketDto ticketDto) {
        Ticket ticket = new Ticket();

        if(ticketDto.getDescription() == null)
            throw new IllegalArgumentException("Description bos olmamali");
        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        ticket = ticketRepository.save(ticket);

        TicketModel ticketModel = TicketModel.builder().description(ticket.getDescription())
                                    .notes(ticket.getNotes())
                                    .id(ticket.getId())
                                    .priorityType(ticket.getPriorityType().getLabel())
                                    .ticketStatus(ticket.getTicketStatus().getLabel())
                                    .ticketDate(ticket.getTicketDate()).build();
        ticketElasticRepository.save(ticketModel);

        ticketDto.setId(ticket.getId());
        return ticketDto;
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
