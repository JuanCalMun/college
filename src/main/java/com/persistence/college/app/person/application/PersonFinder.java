package com.persistence.college.app.person.application;

import com.persistence.college.app.person.model.Person;
import com.persistence.college.app.person.model.PersonDto;
import com.persistence.college.app.person.model.PersonMapper;
import com.persistence.college.app.person.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonFinder {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonFinder(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public List<PersonDto> findAll() {
        return personMapper.mapEntityToDto(personRepository.findAll());
    }

    public List<PersonDto> findByCriteria(PersonDto criteria) {
        Person criteriaEntity = personMapper.mapDtoToEntity(criteria);
        List<Person> entitiesFinded = personRepository.findByCriteria(criteriaEntity);
        return personMapper.mapEntityToDto(entitiesFinded);
    }
}
