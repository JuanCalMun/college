package com.persistence.college.app.person.controller;

import com.persistence.college.app.person.application.PersonFinder;
import com.persistence.college.app.person.model.PersonDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
    public List<PersonDto> getPersonsByCriteria(@PathVariable PersonDto personDto) {
        return personFinder.findAll();
    }
}
