package com.sa.development.eManager.domain.ticket;

import com.sa.development.eManager.domain.ticket.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, String> {}
