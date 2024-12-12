package com.sa.development.eManager.__shared;

import jakarta.persistence.MappedSuperclass;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
public abstract class EntityBase<ID extends Serializable> implements Serializable {

    @Serial
    private static final long serialVersionUID = -1745838616630218107L;

    public abstract ID setId();

    public abstract ID getId();

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public abstract void validate();
}
