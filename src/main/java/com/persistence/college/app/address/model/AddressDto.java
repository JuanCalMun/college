package com.persistence.college.app.address.model;

import com.persistence.college.app.shared.model.DtoBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AddressDto extends DtoBase {
    private static final long serialVersionUID = -6171206516990183142L;

    private long id;
    private String country;
    private String street;
    private int number;
    private int postalcode;

}
