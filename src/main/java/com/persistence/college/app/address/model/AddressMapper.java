package com.persistence.college.app.address.model;

import com.persistence.college.app.shared.model.mappers.MapperBase;
import org.mapstruct.Mapper;

@Mapper
public interface AddressMapper extends MapperBase<Address, AddressDto> {
}
