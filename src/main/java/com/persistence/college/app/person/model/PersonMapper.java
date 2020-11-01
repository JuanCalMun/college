package com.persistence.college.app.person.model;

import com.persistence.college.app.address.model.AddressMapper;
import com.persistence.college.app.shared.model.mappers.MapperBase;
import org.mapstruct.Mapper;

@Mapper(uses = {AddressMapper.class})
public interface PersonMapper extends MapperBase<Person, PersonDto> {
}
