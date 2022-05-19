package depo;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import stok.ArtsOfWagon;
import stok.EngineTypes;
import stok.Locomotive;
import stok.Wagon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleksandr Kokhaniuk
 * @created 5/18/2022, 7:28 AM
 */
public class GoodsTrainFactory implements TrainFactory {
    private int emptyWeight;
    private int numberOfPassengersOfWagons;
    private int numberOfPassengersOfLocomotive;
    private int loadingGoodsOfTrain;
    private int maximalLoadingOfOneTrain;
    private int tractiveEffortOfTrain;
    private int totalWeight;
    private int lengthOfTrain;
    private boolean needConductor;
    private int necessaryConductor;

    private ArtsOfWagon artsOfWagon;
    private EngineTypes engineTypes;
    private Train train;
    private Depo depo;

    private static final Logger LOGGER = Logger.getLogger(LoggerFactory.class.getName());

    public GoodsTrainFactory(EngineTypes engineTypes, ArtsOfWagon artsOfWagon, Depo depo) {
        this.artsOfWagon = artsOfWagon;
        this.engineTypes = engineTypes;
        this.depo = depo;
    }

    @Override
    public Train createTrain(int weightForGoods) {
        clearTrainAdnFild();
        this.depo = depo;
        if (addWagonFromDepoByWeight(weightForGoods)) {
            train.setEmptyWeight(emptyWeight);
            train.setNumberOfPassengersOfWagons(numberOfPassengersOfWagons);
            train.setLoadingGoodsOfTrain(loadingGoodsOfTrain);
            train.setMaximalLoadingOfOneTrain(maximalLoadingOfOneTrain);
            train.setNeedConductor(needConductor);
            train.setNecessaryConductor(necessaryConductor);
        } else {
            LOGGER.warn("There are not enough wagons in the depot to form a train");
            clearTrainAdnFild();
        }
        if (addLocomotiveToTrain()) {
            train.setTotalWeight(totalWeight);
            train.setLengthOfTrain(lengthOfTrain);
        } else {
            LOGGER.warn("There are not enough locomotives in the depot to form a train");
            clearTrainAdnFild();
        }
        return train;
    }

    @Override
    public Train createTrain(int numberOfPassengers, EngineTypes engineTypes, ArtsOfWagon artsOfWagon) {
        clearTrainAdnFild();
        this.engineTypes = engineTypes;
        this.artsOfWagon = artsOfWagon;
        if (addWagonFromDepoByPassengers(numberOfPassengers)) {
            train.setEmptyWeight(emptyWeight);
            train.setNumberOfPassengersOfWagons(numberOfPassengersOfWagons);
            train.setLoadingGoodsOfTrain(loadingGoodsOfTrain);
            train.setMaximalLoadingOfOneTrain(maximalLoadingOfOneTrain);
            train.setNeedConductor(needConductor);
            train.setNecessaryConductor(necessaryConductor);
        } else {
            LOGGER.warn("There are not enough wagons in the depot to form a train");
            clearTrainAdnFild();
        }

        if (addLocomotiveToTrain()) {
            train.setTotalWeight(totalWeight);
            train.setLengthOfTrain(lengthOfTrain);
        } else {
            LOGGER.warn("There are not enough locomotives in the depot to form a train");
            clearTrainAdnFild();
        }

        return train;
    }

    private boolean addWagonFromDepoByPassengers(int numberOfPassengers) {
        for (int i = 0; i < this.depo.getWagonList().size() - 1; i++) {
            if (this.depo.getWagonList().get(i).getArtsOfWagon() == artsOfWagon) {
                train.addWagon(this.depo.getWagonList().get(i));
                this.depo.replaceWagon(i);
                emptyWeight += this.depo.getWagonList().get(i).getEmptyWeigh();
                numberOfPassengersOfWagons += this.depo.getWagonList().get(i).getNumberOfPassengers();
                lengthOfTrain += this.depo.getWagonList().get(i).getLength();
                loadingGoodsOfTrain += this.depo.getWagonList().get(i).getWeightForGoods();
                i = 0;
            }
            if (numberOfPassengersOfWagons >= numberOfPassengers) {
                maximalLoadingOfOneTrain = (numberOfPassengersOfWagons * 75) + loadingGoodsOfTrain;
                if (numberOfPassengersOfWagons > 0) {
                    needConductor = true;
                    necessaryConductor = numberOfPassengersOfWagons / 50;
                    if (!(numberOfPassengersOfWagons % 50 == 0)) {
                        necessaryConductor += 1;
                    }
                    return true;
                }
            }
        }
        if (numberOfPassengersOfWagons < numberOfPassengers) {
            for (Wagon w : train.getWagonList()) {
                this.depo.returnWagon(w);
            }
        }
        return false;
    }


    private boolean addWagonFromDepoByWeight(int weightForGoods) {

        for (int i = 0; i < this.depo.getWagonList().size() - 1; i++) {
            if (this.depo.getWagonList().get(i).getArtsOfWagon() == artsOfWagon) {
                train.addWagon(this.depo.getWagonList().get(i));
                this.depo.replaceWagon(i);
                emptyWeight += this.depo.getWagonList().get(i).getEmptyWeigh();
                numberOfPassengersOfWagons += this.depo.getWagonList().get(i).getNumberOfPassengers();
                lengthOfTrain += this.depo.getWagonList().get(i).getLength();
                loadingGoodsOfTrain += this.depo.getWagonList().get(i).getWeightForGoods();
                if (loadingGoodsOfTrain >= weightForGoods) {
                    break;
                }
                i = 0;
            }
        }
        if (loadingGoodsOfTrain < weightForGoods) {
            for (Wagon w : train.getWagonList()) {
                this.depo.returnWagon(w);
            }
            return false;
        }
        maximalLoadingOfOneTrain = (numberOfPassengersOfWagons * 75) + loadingGoodsOfTrain;
        if (numberOfPassengersOfWagons > 0) {
            needConductor = true;
            necessaryConductor = numberOfPassengersOfWagons / 50;
            if (!(numberOfPassengersOfWagons % 50 == 0)) {
                necessaryConductor += 1;
            }
        }
        return true;
    }

    private boolean addLocomotiveToTrain() {
        for (int i = 0; i < depo.getLocomotiveList().size() - 1; i++) {
            if (depo.getLocomotiveList().get(i).getEngineTypes() == engineTypes) {
                train.addLocomotive(depo.getLocomotiveList().get(i));
                tractiveEffortOfTrain = depo.getLocomotiveList().get(i).getTractiveEffort();
                numberOfPassengersOfLocomotive = depo.getLocomotiveList().get(i).getNumberOfPassengers();
                totalWeight += depo.getLocomotiveList().get(i).getEmptyWeigh();
                lengthOfTrain += depo.getLocomotiveList().get(i).getLength();
                depo.replaceLocomotive(i);
                break;
            }
        }
        for (int i = 0; i < depo.getLocomotiveList().size() - 1; i++) {
            if (depo.getLocomotiveList().get(i).getEngineTypes() == engineTypes) {
                if (tractiveEffortOfTrain < maximalLoadingOfOneTrain |
                        numberOfPassengersOfLocomotive < numberOfPassengersOfWagons) {
                    train.addLocomotive(depo.getLocomotiveList().get(i));
                    tractiveEffortOfTrain += depo.getLocomotiveList().get(i).getTractiveEffort();
                    numberOfPassengersOfLocomotive += depo.getLocomotiveList().get(i).getNumberOfPassengers();
                    totalWeight += depo.getLocomotiveList().get(i).getEmptyWeigh();
                    lengthOfTrain += depo.getLocomotiveList().get(i).getLength();
                    depo.replaceLocomotive(i);
                    i = 0;
                }
            }
            if (tractiveEffortOfTrain > maximalLoadingOfOneTrain &
                    numberOfPassengersOfLocomotive > numberOfPassengersOfWagons) {
                return true;
            }
        }
        for (Locomotive l : train.getLocomotiveList()) {
            depo.returnLocomotive(l);
        }
        return false;
    }

    void clearTrainAdnFild() {
        this.train = new GoodsTrain();
        emptyWeight = 0;
        numberOfPassengersOfWagons = 0;
        numberOfPassengersOfLocomotive = 0;
        loadingGoodsOfTrain = 0;
        maximalLoadingOfOneTrain = 0;
        totalWeight = 0;
        lengthOfTrain = 0;
        needConductor = false;
        necessaryConductor = 0;
        tractiveEffortOfTrain = 0;
    }
}
