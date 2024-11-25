package com.sa.development.eManager.__shared;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MapperBase<E, D> {

    D toDto(E entity);

    List<D> toDtoList(List<E> entities);

    E toEntity(D dto);

    List<E> toEntityList(List<D> dtos);
}
