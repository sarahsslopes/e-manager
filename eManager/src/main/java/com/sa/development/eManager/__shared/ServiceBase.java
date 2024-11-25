package com.sa.development.eManager.__shared;

import java.io.Serializable;
import java.util.List;

public interface ServiceBase<T, ID extends Serializable> {

    T findById(ID id);

    void save(T dto);

    List<T> findAll();

    void delete(ID id);
}
