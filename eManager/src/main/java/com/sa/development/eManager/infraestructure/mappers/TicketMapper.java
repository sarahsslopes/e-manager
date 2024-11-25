package com.sa.development.eManager.infraestructure.mappers;

import com.sa.development.eManager.application.dtos.ticket.TicketDto;
import com.sa.development.eManager.__shared.MapperBase;
import com.sa.development.eManager.domain.ticket.entities.TicketEntity;
import org.mapstruct.factory.Mappers;

public interface TicketMapper extends MapperBase<TicketEntity, TicketDto> {

    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);
}
