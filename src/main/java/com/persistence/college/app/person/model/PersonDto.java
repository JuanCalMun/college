package com.persistence.college.app.person.model;

import com.persistence.college.app.address.model.Address;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PersonDto {
    private UUID uuid;
    private String name;
    private String surname;
    private Address address;

}
