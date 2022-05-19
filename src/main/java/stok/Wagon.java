package stok;


/**
 * @author Oleksandr Kokhaniuk
 * @created 5/15/2022, 7:16 AM
 */

public class Wagon extends RollingStock{
ArtsOfWagon artsOfWagon;

    public ArtsOfWagon getArtsOfWagon() {
        return artsOfWagon;
    }

    public void setArtsOfWagon(String artsOfWagon) {
        this.artsOfWagon = ArtsOfWagon.fromString(artsOfWagon);
    }

    @Override
    public String toString() {
        return "Wagon{" +
                "typeOfDesignation='" + typeOfDesignation + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", serialNumber=" + serialNumber +
                ", emptyWeigh=" + emptyWeigh +
                ", length=" + length +
                ", numberOfPassengers=" + numberOfPassengers +
                ", weightForGoods=" + weightForGoods +
                ", artsOfWagon=" + artsOfWagon +
                ", sequenceNumber=" + sequenceNumber +
                '}';
    }
}
