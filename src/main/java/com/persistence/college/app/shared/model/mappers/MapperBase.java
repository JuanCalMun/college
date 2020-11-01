package com.persistence.college.app.shared.model.mappers;

import com.persistence.college.app.shared.model.DtoBase;
import com.persistence.college.app.shared.model.EntityBase;
import com.persistence.college.app.shared.model.exceptions.LazyEntityMapException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.proxy.HibernateProxy;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperBase<E extends EntityBase, D extends DtoBase> {

    @Slf4j
    final class LogHolder {
    }

    @Named("internalMapEntityToDto")
    D internalMapEntityToDto(E entity);

    @Named("internalMapDtoToEntity")
    E internalMapDtoToEntity(D dto);

    default D mapEntityToDto(E entity) {
        try {
            return internalMapEntityToDto(entity);
        } catch (LazyEntityMapException e) {
            LogHolder.log.info(e.getMessage());
            return null;
        }
    }

    default E mapDtoToEntity(D dto) {
        try {
            return internalMapDtoToEntity(dto);
        } catch (LazyEntityMapException e) {
            LogHolder.log.info(e.getMessage());
            return null;
        }
    }

    default List<D> mapEntityToDto(List<E> entities) {
        return entities.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    default List<E> mapDtoToEntity(List<D> dtos) {
        return dtos.stream()
                .map(this::mapDtoToEntity)
                .collect(Collectors.toList());
    }

    @BeforeMapping
    default void avoidMapLazyObjects(E source) throws RuntimeException {
        if (source instanceof HibernateProxy) throw new LazyEntityMapException();
    }
}
