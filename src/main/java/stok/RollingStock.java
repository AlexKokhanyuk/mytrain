package stok;

import javax.xml.crypto.Data;

/**
 * @author Oleksandr Kokhaniuk
 * @created 5/14/2022, 1:15 PM
 */

public abstract class RollingStock {
    protected String typeOfDesignation;
    protected String manufacturer;
    protected int yearOfProduction;
    protected int serialNumber;
    protected int emptyWeigh;
    protected int length;

    protected int numberOfPassengers;
    protected int weightForGoods;

    protected int sequenceNumber;

    public String getTypeOfDesignation() {
        return typeOfDesignation;
    }

    public void setTypeOfDesignation(String typeOfDesignation) {
        this.typeOfDesignation = typeOfDesignation;

    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getEmptyWeigh() {
        return emptyWeigh;
    }

    public void setEmptyWeigh(int emptyWeigh) {
        this.emptyWeigh = emptyWeigh;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getWeightForGoods() {
        return weightForGoods;
    }

    public void setWeightForGoods(int weightForGoods) {
        this.weightForGoods = weightForGoods;
    }



    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
}
