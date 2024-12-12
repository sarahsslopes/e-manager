package com.sa.development.eManager.domain.ticket;

import com.sa.development.eManager.__shared.RepositoryBase;
import com.sa.development.eManager.domain.ticket.entities.TicketEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends RepositoryBase<TicketEntity, String> {}
