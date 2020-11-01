package com.persistence.college.app.person.controller;

import com.persistence.college.app.person.application.PersonFinder;
import com.persistence.college.app.person.model.PageablePersonDto;
import com.persistence.college.app.person.model.PersonDto;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/person")
public class PersonRestController {

    private final PersonFinder personFinder;

    public PersonRestController(PersonFinder personFinder) {
        this.personFinder = personFinder;
    }

    @GetMapping
    public List<PersonDto> getAllPersons() {
        return personFinder.findAll();
    }

    @PostMapping
    public PageImpl<PersonDto> getPersonsByCriteria(@RequestBody PageablePersonDto personDto) {
        return personFinder.findByCriteria(personDto);
    }
}
