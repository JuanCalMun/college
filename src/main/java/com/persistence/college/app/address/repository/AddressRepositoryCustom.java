package com.persistence.college.app.address.repository;

import com.persistence.college.app.address.model.Address;

import java.util.List;

public interface AddressRepositoryCustom {
    List<Address> findByCriteria(Address criteria);
}
