package com.sa.development.eManager.application.services.ticket;

import com.sa.development.eManager.__shared.ServiceBase;
import com.sa.development.eManager.__shared.exceptions.NotFoundException;
import com.sa.development.eManager.application.dtos.ticket.TicketDto;
import com.sa.development.eManager.domain.ticket.TicketRepository;
import com.sa.development.eManager.domain.ticket.entities.TicketEntity;
import com.sa.development.eManager.infraestructure.mappers.TicketMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ServiceBase<TicketDto, String> {

    @Resource
    private TicketRepository ticketRepository;

    private final TicketMapper ticketMapper = TicketMapper.INSTANCE;

    @Override
    public TicketDto findById(String id) {
        return ticketRepository.findById(id)
                .map(ticketMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Ticket not found"));
    }

    @Override
    public void save(TicketDto dto) {
        ticketRepository.save(ticketMapper.toEntity(dto));
    }

    @Override
    public List<TicketDto> findAll() {
        List<TicketEntity> tickets = ticketRepository.findAll();

        if (tickets.isEmpty()) {
            throw new NotFoundException("No tickets found");
        }

        return ticketMapper.toDtoList(tickets);
    }

    @Override
    public void delete(String id) {
        if (!ticketRepository.existsById(id)) {
            throw new NotFoundException("Ticket not found");
        }

        ticketRepository.deleteById(id);
    }
}
