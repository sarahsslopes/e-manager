package src.main.java.com.sa.development.eManager.domain.person.entities.enums;

public enum Profile {
    ADMIN(0),
    CUSTOMER(1),
    TECHNICAL(2),;

    private final Integer code;

    Profile(Integer code) {
        this.code = code;
    }

    public static Profile getProfile(Integer code) {
        if (code == null) return null;

        for (Profile type : Profile.values()) {
            if (type.code.equals(code)) return type;
        }

        throw new IllegalArgumentException("No Profile with code " + code + " found");
    }
}
