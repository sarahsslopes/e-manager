package com.sa.development.eManager.infraestructure.mappers;

import com.sa.development.eManager.application.dtos.customer.CustumerDto;
import com.sa.development.eManager.domain.__shared.MapperBase;
import com.sa.development.eManager.domain.customer.entities.CustomerEntity;
import org.mapstruct.factory.Mappers;

public interface EmployeeMapper extends MapperBase<CustomerEntity, CustumerDto> {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
}