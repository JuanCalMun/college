package com.persistence.college.app.person.model;

import com.persistence.college.app.address.model.AddressDto;
import com.persistence.college.app.shared.model.DtoBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PersonDto extends DtoBase {
    private static final long serialVersionUID = -4067358506944430997L;

    private UUID uuid;
    private String name;
    private String surname;
    private AddressDto address;

}
