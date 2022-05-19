package depo;

import stok.Locomotive;
import stok.Wagon;

import java.util.List;

/**
 * @author Oleksandr Kokhaniuk
 * @created 5/15/2022, 7:33 AM
 */

public interface Train {

    int getEmptyWeight();

    void setEmptyWeight(int emptyWeight );

    int getNumberOfPassengersOfWagons();

    void setNumberOfPassengersOfWagons(int numberOfPassengers);

    int getNumberOfPassengersOfLocomotive();

    void setNumberOfPassengersOfLocomotive(int numberOfPassengers);

    int getLoadingGoodsOfTrain();

    void setLoadingGoodsOfTrain(int loadingGoodsOfTrain);

    int getMaximalLoadingOfOneTrain();

    void setMaximalLoadingOfOneTrain(int maximalLoadingOfOneTrain);

    int getTotalWeight();// x 75 kg +max

    void  setTotalWeight(int totalWeight);

    int getLengthOfTrain();

    void setLengthOfTrain(int lengthOfTrain);

    boolean getNeedConductor();

    int getNecessaryConductor();

    void setNeedConductor(boolean needConductor);

    void setNecessaryConductor(int necessaryConductor);

    void addWagon(Wagon wagon);

    void addLocomotive(Locomotive locomotive);

    List<Locomotive> getLocomotiveList();

    List<Wagon> getWagonList();

}
