package com.sa.development.eManager.__shared;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public interface ServiceBase<T, ID extends Serializable> {

    T findById(ID id);

    @Transactional
    void save(T dto);

    List<T> findAll();

    @Transactional
    void delete(ID id);
}
