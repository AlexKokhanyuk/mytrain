package depo;

import junit.framework.TestCase;
import stok.ArtsOfWagon;
import stok.EngineTypes;

/**
 * @author Oleksandr Kokhaniuk
 * @created 5/18/2022, 10:22 PM
 */
public class GoodsTrainFactoryTest extends TestCase {


    public void testCreateTrain() {
        Depo depo = new Depo();
        depo.crateRollingStock();
        GoodsTrainFactory goodsTrainFactory = new GoodsTrainFactory(EngineTypes.DIESEL, ArtsOfWagon.GOODS, depo);
        Train train = goodsTrainFactory.createTrain(1000);
        assertEquals(train.getLocomotiveList().get(0).getEngineTypes(), EngineTypes.DIESEL);
        assert (train.getLoadingGoodsOfTrain() >= 1000);
    }

    public void testTestCreateTrain() {
        Depo depo = new Depo();
        depo.crateRollingStock();
        GoodsTrainFactory goodsTrainFactory = new GoodsTrainFactory(EngineTypes.DIESEL, ArtsOfWagon.GOODS, depo);
        Train train = goodsTrainFactory.createTrain(50, EngineTypes.ELECTRIC, ArtsOfWagon.DINING);
        assertEquals(train.getWagonList().get(0).getArtsOfWagon(), ArtsOfWagon.DINING);
        assert (train.getNumberOfPassengersOfWagons() >= 50);
    }
}