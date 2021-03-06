package com.persistence.college.app.person.repository;

import com.persistence.college.app.address.model.Address;
import com.persistence.college.app.person.model.Person;
import com.persistence.college.app.person.model.QPerson;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepositoryCustom {

    private EntityManager entityManager;

    public PersonRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Person> findAll() {
        JPAQuery<Person> query = new JPAQuery(entityManager);
        QPerson qPerson = QPerson.person;

        List<Person> fetch = query
                .from(qPerson)
                .innerJoin(qPerson.address).fetchJoin()
                .fetch();
        return fetch;
    }

    @Override
    public PageImpl<Person> findByCriteria(Person criteria, Pageable pageable) {

        JPAQuery<Person> query = new JPAQuery(entityManager);
        QPerson qPerson = QPerson.person;
        BooleanBuilder predicate = generateCriteriaPredicate(criteria, qPerson);

        JPAQuery<Person> allResults = query
                .from(qPerson)
                .innerJoin(qPerson.address).fetchJoin()
                .where(predicate).fetchAll();

        List<Person> finalResults = allResults
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize()).fetch();
        return new PageImpl<>(finalResults, pageable, allResults.fetchCount());
    }

    private BooleanBuilder generateCriteriaPredicate(Person criteria, QPerson qPerson) {
        BooleanBuilder predicate = new BooleanBuilder();
        String criteriaName = criteria.getName();
        String criteriaSurname = criteria.getSurname();
        Address criteriaAddress = criteria.getAddress();

        if (!StringUtils.isEmpty(criteriaName)) {
            predicate.and(qPerson.name.eq(criteriaName));
        }
        if (!StringUtils.isEmpty(criteriaSurname)) {
            predicate.and(qPerson.surname.eq(criteriaSurname));
        }
        if (!ObjectUtils.isEmpty(criteriaAddress)) {
            predicate.and(qPerson.address.eq(criteriaAddress));
        }

        return predicate;
    }
}
