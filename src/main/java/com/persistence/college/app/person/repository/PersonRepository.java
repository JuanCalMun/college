package com.persistence.college.app.person.repository;

import com.persistence.college.app.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PersonRepository extends
        JpaRepository<Person, Long>,
        QuerydslPredicateExecutor<Person>,
        PersonRepositoryCustom {

}
