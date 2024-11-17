package src.main.java.com.sa.development.eManager.domain;

import java.io.Serial;
import java.io.Serializable;

public abstract class AbstractEntityBase<ID extends Serializable> implements Serializable {

    @Serial
    private static final long serialVersionUID = -1745838616630218107L;
}
