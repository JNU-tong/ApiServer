package kr.ac.jejunu.service;

import kr.ac.jejunu.model.response.DepartureSoonBus;
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
public class BusServiceTest {
    @Autowired
    private BusService busService;

    @Test
    public void getAfterNowBusScheduleListTest() throws ParseException {
        HashMap<String, DepartureSoonBus> busScheduleArrayList = busService.getDepartureSoonBusList();


        assertThat(busScheduleArrayList.size(), not(0));
    }
}