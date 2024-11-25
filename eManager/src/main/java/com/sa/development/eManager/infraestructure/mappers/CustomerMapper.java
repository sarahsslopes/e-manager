package com.sa.development.eManager.infraestructure.mappers;

import com.sa.development.eManager.application.dtos.customer.CustomerDto;
import com.sa.development.eManager.__shared.MapperBase;
import com.sa.development.eManager.domain.customer.entities.CustomerEntity;
import org.mapstruct.factory.Mappers;

public interface CustomerMapper extends MapperBase<CustomerEntity, CustomerDto> {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
}
