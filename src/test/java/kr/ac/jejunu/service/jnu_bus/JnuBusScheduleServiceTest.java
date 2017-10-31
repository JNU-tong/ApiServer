package kr.ac.jejunu.service.jnu_bus;

import kr.ac.jejunu.model.jpa.jnu_bus.JnuBusSchedule;
import kr.ac.jejunu.model.response.RemainTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JnuBusScheduleServiceTest {
    @Autowired
    private JnuBusScheduleService jnuBusScheduleService;

    @Test
    public void getBusScheduleListTest() {
        String course = "B";
        ArrayList<JnuBusSchedule> jnuBusScheduleArrayList = jnuBusScheduleService.getJnuBusScheduleListByCourse(course);

        for (JnuBusSchedule busSchedule : jnuBusScheduleArrayList) {
            System.out.println(busSchedule.getDepartureTime());
            System.out.println(busSchedule.getCourse());
        }
    }
}