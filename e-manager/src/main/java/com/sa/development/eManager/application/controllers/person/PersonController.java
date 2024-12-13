package com.sa.development.eManager.application.controllers.person;

import com.sa.development.eManager.application.dtos.person.PersonDto;
import com.sa.development.eManager.application.services.person.PersonService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Resource
    private PersonService personService;

    @GetMapping(value = "/{id}")
    public PersonDto getPerson(@PathVariable String id) {
        return personService.findById(id);
    }

    @GetMapping
    public List<PersonDto> listServices() {
        return personService.findAll();
    }

    @PostMapping
    public void createService(@RequestBody PersonDto personDto) {
        personService.save(personDto);
    }
}
