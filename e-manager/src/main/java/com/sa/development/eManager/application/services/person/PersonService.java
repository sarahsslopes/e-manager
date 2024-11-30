package com.sa.development.eManager.application.services.person;

import com.sa.development.eManager.__shared.ServiceBase;
import com.sa.development.eManager.__shared.exceptions.NotFoundException;
import com.sa.development.eManager.application.dtos.person.PersonDto;
import com.sa.development.eManager.domain.person.PersonRepository;
import com.sa.development.eManager.domain.person.entities.PersonEntity;
import com.sa.development.eManager.infraestructure.mappers.PersonMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements ServiceBase<PersonDto, String> {

    @Resource
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Override
    public PersonDto findById(String id) {
        return personRepository.findById(id)
                .map(personMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Person not found"));
    }

    @Override
    public void save(PersonDto dto) {
        personRepository.save(personMapper.toEntity(dto));
    }

    @Override
    public List<PersonDto> findAll() {
        List<PersonEntity> persons = personRepository.findAll();

        if (persons.isEmpty()) {
            throw new NotFoundException("No persons found");
        }

        return personMapper.toDtoList(persons);
    }

    @Override
    public void delete(String id) {
        if (!personRepository.existsById(id)) {
            throw new NotFoundException("Person not found");
        }
        personRepository.deleteById(id);
    }
}
