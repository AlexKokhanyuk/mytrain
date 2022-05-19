package stok;

/**
 * @author Oleksandr Kokhaniuk
 * @created 5/15/2022, 7:24 AM
 */
public enum ArtsOfWagon {
    PASSENGERS ("PASSENGERS"),
    SLEEPING ("SLEEPING"),
    DINING("DINING"),
    GOODS("GOODS");

    private String value;

    ArtsOfWagon(String value) {
        this.value = value;
    }

    public static ArtsOfWagon fromString(String value) {
        if (value != null) {
            for (ArtsOfWagon pt : ArtsOfWagon.values()) {
                if (value.equalsIgnoreCase(pt.value)) {
                    return pt;
                }
            }
        }
        throw new IllegalArgumentException("No such value");
    }
}
