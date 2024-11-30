package com.sa.development.eManager.__shared;

import java.util.List;

public interface MapperBase<E, D> {

    D toDto(E entity);

    List<D> toDtoList(List<E> entities);

    E toEntity(D dto);

    List<E> toEntityList(List<D> dtos);
}
