package stok;

/**
 * @author Oleksandr Kokhaniuk
 * @created 5/15/2022, 7:12 AM
 */
public enum EngineTypes {
    DIESEL("DIESEL"),
    STEAM("STEAM"),
    ELECTRIC("ELECTRIC");

    private String value;

     EngineTypes(String value) {
        this.value = value;
    }

    public static EngineTypes fromString(String value) {
        if (value != null) {
            for (EngineTypes pt : EngineTypes.values()) {
                if (value.equalsIgnoreCase(pt.value)) {
                    return pt;
                }
            }
        }
        throw new IllegalArgumentException("No such value");
    }
}


