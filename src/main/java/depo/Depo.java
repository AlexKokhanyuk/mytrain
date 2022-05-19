package depo;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import stok.Locomotive;
import stok.Wagon;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;


/**
 * @author Oleksandr Kokhaniuk
 * @created 5/14/2022, 1:36 PM
 */

public class Depo {

    private static final Logger LOGGER = Logger.getLogger(LoggerFactory.class.getName());
    private List<Locomotive> locomotiveList = new LinkedList<>();
    private List<Wagon> wagonList = new LinkedList<>();

    public List<Locomotive> getLocomotiveList() {
        return locomotiveList;
    }

    public Locomotive replaceLocomotive(int index) {
        Locomotive locomotive = locomotiveList.get(index);
        locomotiveList.remove(index);
        return locomotive;
    }

    public List<Wagon> getWagonList() {
        return wagonList;
    }

    public Wagon replaceWagon(int index) {
        Wagon wagon = wagonList.get(index);
        wagonList.remove(index);

        return wagon;
    }

    public void crateRollingStock() {
        String fileName;
        Properties prop = new Properties();
        try {
            prop.load(Depo.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            LOGGER.warn(e);
        }
        fileName = prop.getProperty("rollingStocksFilePath");

        NodeList nodeListLocomotive = getNodeList(fileName, "locomotive");
        if (!(nodeListLocomotive == null)) {
            for (int i = 0; i < nodeListLocomotive.getLength(); i++) {
                Locomotive locomotive = new Locomotive();
                Node nNode = nodeListLocomotive.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    locomotive.setTypeOfDesignation(eElement.getElementsByTagName("typeOfDesignation")
                            .item(0).getTextContent().strip());
                    locomotive.setManufacturer(eElement.getElementsByTagName("manufacturer")
                            .item(0).getTextContent().strip());
                    locomotive.setYearOfProduction(Integer.parseInt(eElement.getElementsByTagName("yearOfProduction")
                            .item(0).getTextContent().strip()));
                    locomotive.setSerialNumber(Integer.parseInt(eElement.getElementsByTagName("serialNumber")
                            .item(0).getTextContent().strip()));
                    locomotive.setEmptyWeigh(Integer.parseInt(eElement.getElementsByTagName("emptyWeigh")
                            .item(0).getTextContent().strip()));
                    locomotive.setLength(Integer.parseInt(eElement.getElementsByTagName("length")
                            .item(0).getTextContent().strip()));
                    locomotive.setNumberOfPassengers(Integer.parseInt(eElement.getElementsByTagName("numberOfPassengers")
                            .item(0).getTextContent().strip()));
                    locomotive.setWeightForGoods(Integer.parseInt(eElement.getElementsByTagName("weightForGoods")
                            .item(0).getTextContent().strip()));
                    locomotive.setWeightForGoods(Integer.parseInt(eElement.getElementsByTagName("weightForGoods")
                            .item(0).getTextContent().strip()));
                    locomotive.setTractiveEffort(Integer.parseInt(eElement.getElementsByTagName("tractiveEffort")
                            .item(0).getTextContent().strip()));
                    locomotive.setEngineTypes(eElement.getElementsByTagName("engineTypes")
                            .item(0).getTextContent().strip());
                    locomotiveList.add(locomotive);
                }
            }
        }

        NodeList nodeListWagon = getNodeList(fileName, "wagon");
        if (!(nodeListWagon == null)) {
            for (int i = 0; i < nodeListWagon.getLength(); i++) {
                Wagon wagon = new Wagon();
                Node nNode = nodeListWagon.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    wagon.setTypeOfDesignation(eElement.getElementsByTagName("typeOfDesignation")
                            .item(0).getTextContent().strip());
                    wagon.setManufacturer(eElement.getElementsByTagName("manufacturer")
                            .item(0).getTextContent().strip());
                    wagon.setYearOfProduction(Integer.parseInt(eElement.getElementsByTagName("yearOfProduction")
                            .item(0).getTextContent().strip()));
                    wagon.setSerialNumber(Integer.parseInt(eElement.getElementsByTagName("serialNumber")
                            .item(0).getTextContent().strip()));
                    wagon.setEmptyWeigh(Integer.parseInt(eElement.getElementsByTagName("emptyWeigh")
                            .item(0).getTextContent().strip()));
                    wagon.setLength(Integer.parseInt(eElement.getElementsByTagName("length")
                            .item(0).getTextContent().strip()));
                    wagon.setNumberOfPassengers(Integer.parseInt(eElement.getElementsByTagName("numberOfPassengers")
                            .item(0).getTextContent().strip()));
                    wagon.setWeightForGoods(Integer.parseInt(eElement.getElementsByTagName("weightForGoods")
                            .item(0).getTextContent().strip()));
                    wagon.setWeightForGoods(Integer.parseInt(eElement.getElementsByTagName("weightForGoods")
                            .item(0).getTextContent().strip()));
                    wagon.setArtsOfWagon((eElement.getElementsByTagName("artsOfWagon")
                            .item(0).getTextContent().strip()));
                    wagonList.add(wagon);
                }
            }
        }

    }

    private NodeList getNodeList(String fileName, String tagName) {
        NodeList nodeList = null;
        try {
            File inputFile = new File(fileName);
            if (inputFile.exists()) {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();
                nodeList = doc.getElementsByTagName(tagName);
            } else {
                LOGGER.warn("File not found");
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return nodeList;
    }
    public void returnWagon(Wagon w) {
        wagonList.add(w);
    }

    public void returnLocomotive(Locomotive l) {
        locomotiveList.add(l);
    }
}