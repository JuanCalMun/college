package com.persistence.college.app.address.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {
    private long id;
    private String country;
    private String street;
    private int number;
    private int postalcode;

}
