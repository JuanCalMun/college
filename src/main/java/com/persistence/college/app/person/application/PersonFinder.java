package com.persistence.college.app.person.application;

import com.persistence.college.app.person.model.PageablePersonDto;
import com.persistence.college.app.person.model.Person;
import com.persistence.college.app.person.model.PersonDto;
import com.persistence.college.app.person.model.PersonMapper;
import com.persistence.college.app.person.repository.PersonRepository;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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

    public PageImpl<PersonDto> findByCriteria(PageablePersonDto filter) {
        Person criteria = personMapper.mapDtoToEntity(filter);
        PageRequest pageable = PageRequest.of(filter.getPage(), filter.getSize());
        PageImpl<Person> entitiesFinded = personRepository.findByCriteria(criteria, pageable);
        List<PersonDto> dtosFinded = personMapper.mapEntityToDto(entitiesFinded);
        return new PageImpl<>(dtosFinded, pageable, entitiesFinded.getTotalElements());
    }
}
