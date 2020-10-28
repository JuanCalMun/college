package com.persistence.college.configuration;

import com.persistence.college.app.address.model.Address;
import com.persistence.college.app.address.repository.AddressRepository;
import com.persistence.college.app.person.model.Person;
import com.persistence.college.app.person.repository.PersonRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.UUID;

@Configuration
public class InitialDatabaseLoad {


    @Bean
    public ApplicationRunner addressInitializer(
            AddressRepository addressRepository) {
        return args -> addressRepository.saveAll(
                Arrays.asList(
                        createAddres("Spain", "Fake road", 123, 39231),
                        createAddres("Ireland", "Main road", 4, 12123)
                ));
    }

    @Bean
    public ApplicationRunner personInitializer(PersonRepository personRepository, AddressRepository addressRepository) {
        return args -> personRepository.saveAll(
                Arrays.asList(
                        createPerson("Jhon", "Connor", addressRepository.getOne(1L)),
                        createPerson("Bender", "Sanchez", addressRepository.getOne(2L)),
                        createPerson("Homer", "Simpson", addressRepository.getOne(2L))
                ));
    }

    private Person createPerson(String name, String surname, Address address) {
        Person person = new Person();
        person.setUuid(UUID.randomUUID());
        person.setName(name);
        person.setSurname(surname);
        person.setAddress(address);
        return person;
    }

    private Address createAddres(String country, String street, int number, int postalcode) {
        Address address = new Address();
        address.setCountry(country);
        address.setStreet(street);
        address.setNumber(number);
        address.setPostalcode(postalcode);
        return address;
    }
}
