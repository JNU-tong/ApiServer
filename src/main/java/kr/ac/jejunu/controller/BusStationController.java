package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.jpa.BusStationInfo;
import kr.ac.jejunu.service.BusStationService;
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
public class BusStationController {
    @Autowired
    private BusStationService busStationService;

    @RequestMapping(value = "/getBusStationListByLineId/{lineId}", method = RequestMethod.GET)
    public ArrayList<BusStationInfo> getBusStationListByLineId(@PathVariable String lineId) throws IOException, ParserConfigurationException, SAXException {
        ArrayList<BusStationInfo> busStationInfoList = busStationService.getBusStationListByLineId(lineId);

        return busStationInfoList;
    }
}
