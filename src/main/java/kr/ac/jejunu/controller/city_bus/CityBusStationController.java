package kr.ac.jejunu.controller.city_bus;

import kr.ac.jejunu.model.response.city_bus.CityBusStationInfo;
import kr.ac.jejunu.service.city_bus.CityBusStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class CityBusStationController {
    @Autowired
    private CityBusStationService cityBusStationService;

    @RequestMapping(value = "/getBusStationListByLineId/{lineId}", method = RequestMethod.GET)
    public ArrayList<CityBusStationInfo> getBusStationListByLineId(@PathVariable String lineId) throws IOException, ParserConfigurationException, SAXException {
        ArrayList<CityBusStationInfo> cityBusStationInfoList = cityBusStationService.getBusStationListByLineId(lineId);

        return cityBusStationInfoList;
    }
}
