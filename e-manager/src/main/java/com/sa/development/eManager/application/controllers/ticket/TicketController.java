package com.sa.development.eManager.application.controllers.ticket;

import com.sa.development.eManager.application.dtos.ticket.TicketDto;
import com.sa.development.eManager.application.services.ticket.TicketService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Resource
    private TicketService ticketService;

    @GetMapping(value = "/{id}")
    public TicketDto getPerson(@PathVariable String id) {
        return ticketService.findById(id);
    }

    @GetMapping
    public List<TicketDto> listServices() {
        return ticketService.findAll();
    }

    @PostMapping
    public void createService(@RequestBody TicketDto ticketDto) {
        ticketService.save(ticketDto);
    }
}
