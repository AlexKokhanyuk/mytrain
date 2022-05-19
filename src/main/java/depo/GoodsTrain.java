package depo;

import stok.Locomotive;
import stok.Wagon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleksandr Kokhaniuk
 * @created 5/18/2022, 7:29 AM
 */
public class GoodsTrain implements Train {
    private List<Locomotive> locomotiveList = new ArrayList<>();
    private List<Wagon> wagonList = new ArrayList<>();
    private int emptyWeight;
    private int numberOfPassengersOfWagons;
    private int numberOfPassengersOfLocomotive;
    private int loadingGoodsOfTrain;
    private int maximalLoadingOfOneTrain;
    private int totalWeight;
    private int lengthOfTrain;
    private boolean needConductor;
    private int necessaryConductor;

    @Override
    public int getEmptyWeight() {
        return emptyWeight;
    }

    @Override
    public void setEmptyWeight(int emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    @Override
    public int getNumberOfPassengersOfWagons() {
        return numberOfPassengersOfWagons;
    }

    @Override
    public void setNumberOfPassengersOfWagons(int numberOfPassengers) {
        this.numberOfPassengersOfWagons = numberOfPassengers;
    }

    @Override
    public int getNumberOfPassengersOfLocomotive() {
        return numberOfPassengersOfLocomotive;
    }

    @Override
    public void setNumberOfPassengersOfLocomotive(int numberOfPassengers) {
        this.numberOfPassengersOfLocomotive = numberOfPassengers;
    }

    @Override
    public int getLoadingGoodsOfTrain() {
        return loadingGoodsOfTrain;
    }

    @Override
    public void setLoadingGoodsOfTrain(int loadingGoodsOfTrain) {
        this.loadingGoodsOfTrain = loadingGoodsOfTrain;
    }

    @Override
    public int getMaximalLoadingOfOneTrain() {
        return maximalLoadingOfOneTrain;
    }

    @Override
    public void setMaximalLoadingOfOneTrain(int maximalLoadingOfOneTrain) {
        this.maximalLoadingOfOneTrain = maximalLoadingOfOneTrain;
    }

    @Override
    public int getTotalWeight() {
        return totalWeight;
    }

    @Override
    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    @Override
    public int getLengthOfTrain() {
        return lengthOfTrain;
    }

    @Override
    public void setLengthOfTrain(int lengthOfTrain) {
        this.lengthOfTrain = lengthOfTrain;
    }

    @Override
    public boolean getNeedConductor() {
        return needConductor;
    }

    @Override
    public int getNecessaryConductor() {
        return necessaryConductor;
    }

    @Override
    public void setNeedConductor(boolean needConductor) {
        this.needConductor = needConductor;
    }

    @Override
    public void setNecessaryConductor(int necessaryConductor) {
        this.necessaryConductor = necessaryConductor;
    }

    @Override
    public void addWagon(Wagon wagon) {
        this.wagonList.add(wagon);
    }

    @Override
    public void addLocomotive(Locomotive locomotive) {
        this.locomotiveList.add(locomotive);
    }

    @Override
    public List<Locomotive> getLocomotiveList() {
        return locomotiveList;
    }

    @Override
    public List<Wagon> getWagonList() {
        return wagonList;
    }

    @Override
    public String toString() {
        return "Train has " + locomotiveList.size() + " locomotive and " +
                wagonList.size() + " wagons.\n{" +
                "emptyWeight=" + emptyWeight +
                ",\n numberOfPassengers=" + numberOfPassengersOfWagons +
                ",\n loadingGoodsOfTrain=" + loadingGoodsOfTrain +
                ",\n maximalLoadingOfOneTrain=" + maximalLoadingOfOneTrain +
                ",\n totalWeight=" + totalWeight +
                ",\n lengthOfTrain=" + lengthOfTrain +
                ",\n needConductor=" + needConductor +
                ",\n necessaryConductor=" + necessaryConductor +
                "}\n";
    }

}
