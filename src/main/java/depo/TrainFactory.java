package depo;

import stok.ArtsOfWagon;
import stok.EngineTypes;

/**
 * @author Oleksandr Kokhaniuk
 * @created 5/15/2022, 8:22 PM
 */
public interface TrainFactory {

    public Train createTrain(int weightForGoods);

    public Train createTrain(int numberOfPassengers, EngineTypes engineTypes, ArtsOfWagon artsOfWagon);


}
