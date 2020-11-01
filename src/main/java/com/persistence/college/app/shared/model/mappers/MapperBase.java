package com.persistence.college.app.shared.model.mappers;

import com.persistence.college.app.shared.model.DtoBase;
import com.persistence.college.app.shared.model.EntityBase;
import com.persistence.college.app.shared.model.exceptions.LazyEntityMapException;
import org.hibernate.proxy.HibernateProxy;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperBase<E extends EntityBase, D extends DtoBase> {


    Logger logger = LoggerFactory.getLogger(MapperBase.class.getName());

    @Named("internalMapEntityToDto")
    D internalMapEntityToDto(E entity);

    E mapDtoToEntity(D dto);

    default D mapEntityToDto(E entity) {
        try {
            return internalMapEntityToDto(entity);
        } catch (LazyEntityMapException e) {
            logger.debug(
                    "The mapper is trying to map a lazy entity: " + entity.getClass() +
                            ". This entity will be null in dto. ");
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
