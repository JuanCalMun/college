package com.persistence.college.app.person.repository;

import com.persistence.college.app.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonRepositoryImpl implements PersonRepositoryCustom {

    private final PersonRepository personRepository;

    @Autowired
    public PersonRepositoryImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findByCriteria(Person criteria) {
        return null;
    }
}
