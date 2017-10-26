package kr.ac.jejunu.service;

import kr.ac.jejunu.model.jpa.city_bus.CityBusStationInfo;
import kr.ac.jejunu.service.city_bus.BusStationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusStationServiceTest {
    @Autowired
    private BusStationService busStationService;

    @Test
    public void getBusStationListByLineIdTest() throws IOException, ParserConfigurationException, SAXException {
        String lineId = "JEB405327002";
        ArrayList<CityBusStationInfo> cityBusStationInfoArrayList = busStationService.getBusStationListByLineId(lineId);

//        assertThat(cityBusStationInfoArrayList.size(), is(53));
    }

}