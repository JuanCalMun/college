package com.persistence.college.app.person.repository;

import com.persistence.college.app.person.model.Person;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


public interface PersonRepositoryCustom {

    PageImpl<Person> findByCriteria(Person criteria, Pageable pageable);

}
