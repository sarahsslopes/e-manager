package com.sa.development.eManager.infraestructure.mappers;

import com.sa.development.eManager.application.dtos.service.ServiceDto;
import com.sa.development.eManager.__shared.MapperBase;
import com.sa.development.eManager.domain.service.entities.ServiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceMapper extends MapperBase<ServiceEntity, ServiceDto> {

    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);
}