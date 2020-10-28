package com.persistence.college.app.person.repository;

import com.persistence.college.app.person.model.Person;

import java.util.List;

public interface PersonRepositoryCustom {

    List<Person> findByCriteria(Person criteria);

}
