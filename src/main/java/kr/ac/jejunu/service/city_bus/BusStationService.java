package kr.ac.jejunu.service.city_bus;

import kr.ac.jejunu.model.response.city_bus.CityBusStationInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;

@Service
public class BusStationService {
    @Value("${busApi.serviceKey}")
    private String serviceKey;

    @Value("${busApi.url}")
    private String url;

    @Value("${busApi.cityCode}")
    private Integer cityCode;

    @Value("${busApi.numOfRows}")
    private Integer numOfRows;

    private ArrayList<CityBusStationInfo> busStationListByLineId;

    public ArrayList<CityBusStationInfo> getBusStationListByLineId(String lineId) throws IOException, ParserConfigurationException, SAXException {
        URI requestUrl = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host(url)
                .queryParam("ServiceKey", URLDecoder.decode(serviceKey, "UTF-8"))
                .queryParam("cityCode", cityCode)
                .queryParam("numOfRows", numOfRows)
                .queryParam("routeId", lineId)
                .build()
                .toUri();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(requestUrl.toString());

        document.getDocumentElement().normalize();

//        System.out.println("Root element: " + document.getDocumentElement().getNodeName());

        Element bodyElement = (Element) document.getElementsByTagName("body").item(0);

        Element itemsElement = (Element) bodyElement.getElementsByTagName("items").item(0);

        NodeList itemList = itemsElement.getElementsByTagName("item");

//        System.out.println("items length: " + itemList.getLength());


        busStationListByLineId = new ArrayList<>();

        for (int i = 0; i < itemList.getLength(); i++) {
            Node item = itemList.item(i);

            CityBusStationInfo cityBusStationInfo = new CityBusStationInfo();

            if (item.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) item;

//                System.out.println("Station ID : " + getTagValue("nodeid", eElement));
//                System.out.println("Station Name : " + getTagValue("nodenm", eElement));
//                System.out.println("Station Order : " + Integer.parseInt(getTagValue("nodeord", eElement)));

                cityBusStationInfo.setStationId(getTagValue("nodeid", eElement));
                cityBusStationInfo.setStationName(getTagValue("nodenm", eElement));
                cityBusStationInfo.setStationOrder(Integer.parseInt(getTagValue("nodeord", eElement)));

                busStationListByLineId.add(cityBusStationInfo);
            }
        }

        return busStationListByLineId;
    }

    private String getTagValue(String tagName, Element element) {
        return element.getElementsByTagName(tagName).item(0).getChildNodes().item(0).getNodeValue();
    }
}
