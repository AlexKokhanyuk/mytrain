package stok;


/**
 * @author Oleksandr Kokhaniuk
 * @created 5/14/2022, 1:16 PM
 */


public class Locomotive extends RollingStock {
    private int tractiveEffort;
    private EngineTypes engineTypes;

    public int getTractiveEffort() {
        return tractiveEffort;
    }

    public void setTractiveEffort(int tractiveEffort) {
        this.tractiveEffort = tractiveEffort;
    }

    public EngineTypes getEngineTypes() {
        return engineTypes;
    }

    public void setEngineTypes(String engineTypes) {
        this.engineTypes = EngineTypes.fromString(engineTypes);
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "engineTypes=" + engineTypes +
                ", typeOfDesignation='" + typeOfDesignation + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", serialNumber=" + serialNumber +
                ", emptyWeigh=" + emptyWeigh +
                ", length=" + length +
                ", numberOfPassengers=" + numberOfPassengers +
                ", weightForGoods=" + weightForGoods +
                ", sequenceNumber=" + sequenceNumber +
                '}';
    }
}
