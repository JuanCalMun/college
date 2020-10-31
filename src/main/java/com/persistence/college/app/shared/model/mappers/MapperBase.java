package com.persistence.college.app.shared.model.mappers;

import com.persistence.college.app.shared.model.DtoBase;
import com.persistence.college.app.shared.model.EntityBase;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface MapperBase<E extends EntityBase, D extends DtoBase> {

    D mapEntityToDto(E entity);

    E mapDtoToEntity(D entity);

    default List<D> mapEntityToDto(List<E> entities) {
        return Optional.ofNullable(entities)
                .map(this::mapEntityToDto)
                .orElse(Collections.emptyList());
    }

    default List<E> mapDtoToEntity(List<D> dtos) {
        return Optional.ofNullable(dtos)
                .map(this::mapDtoToEntity)
                .orElse(Collections.emptyList());
    }
}
