package com.persistence.college.app.address.repository;

import com.persistence.college.app.address.model.Address;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressRepositoryImpl implements AddressRepositoryCustom {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressRepositoryImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findByCriteria(Address criteria) {
        return null;
    }
}
