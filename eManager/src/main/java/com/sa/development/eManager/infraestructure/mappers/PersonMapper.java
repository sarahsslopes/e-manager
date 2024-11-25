package com.sa.development.eManager.infraestructure.mappers;

import com.sa.development.eManager.application.dtos.person.PersonDto;
import com.sa.development.eManager.__shared.MapperBase;
import com.sa.development.eManager.domain.person.entities.PersonEntity;
import org.mapstruct.factory.Mappers;

public interface PersonMapper extends MapperBase<PersonEntity, PersonDto> {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
}
