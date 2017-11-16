package kr.ac.jejunu.service;

import kr.ac.jejunu.model.response.city_bus.DepartureSoonCityBus;
import kr.ac.jejunu.service.city_bus.CityBusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.HashMap;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * Created by Boobby on 17-9-21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CityBusServiceTest {
    @Autowired
    private CityBusService cityBusService;

    @Test
    public void getAfterNowBusScheduleListTest() throws ParseException {
        HashMap<String, DepartureSoonCityBus> busScheduleArrayList = cityBusService.getDepartureSoonBusList();


        assertThat(busScheduleArrayList.size(), not(0));
    }
}