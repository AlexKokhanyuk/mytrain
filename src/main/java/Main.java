import depo.*;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import stok.ArtsOfWagon;
import stok.EngineTypes;
import stok.Wagon;

/**
 * @author Oleksandr Kokhaniuk
 * @created 5/15/2022, 4:36 PM
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger(LoggerFactory.class.getName());
    static Depo depo;
    public static void main(String[] args) {

        try {
            TrainFactory trainFactory = creteTrainByType("Goods");
            Train trainOne = trainFactory.createTrain(260000);
            System.out.println(trainOne);

            Train trainTwo=trainFactory.createTrain(300,EngineTypes.STEAM,ArtsOfWagon.PASSENGERS);
            System.out.println(trainTwo);
        } catch (Exception e) {
            LOGGER.warn(e);
        }
        System.out.println("Depo has " + depo.getWagonList().size() + " wagons and "
                + depo.getLocomotiveList().size() + " locomotive");
    }

    public static TrainFactory creteTrainByType(String typeOfTrain) {
        depo=new Depo();
        depo.crateRollingStock();
        System.out.println("Depo has " + depo.getWagonList().size() + " wagons and "
                + depo.getLocomotiveList().size() + " locomotive");
        if (typeOfTrain.equalsIgnoreCase("Goods")) {
            TrainFactory trainFactory = new GoodsTrainFactory(EngineTypes.DIESEL, ArtsOfWagon.GOODS, depo);
            return trainFactory;
        } else {
            throw new RuntimeException(typeOfTrain + " is unknown");
        }
    }
}
