package kr.ac.jejunu.service.jnu_bus;

import kr.ac.jejunu.model.jpa.jnu_bus.JnuBusSchedule;
import kr.ac.jejunu.model.response.RemainTime;
import kr.ac.jejunu.model.response.jnu_bus.JnuBusArrivalInfo;
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
public class JnuCityBusScheduleServiceTest {
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

    @Test
    public void getRemainTimeOfStationTest() {
        RemainTime remainTime = jnuBusScheduleService.getRemainTimeOfStationByCourse("B", 13);

        System.out.println(remainTime.getFirst());
        System.out.println(remainTime.getSecond());
    }

    @Test
    public void getJnuBusArrivalInfoListTest() {
        ArrayList<JnuBusArrivalInfo> list = jnuBusScheduleService.getJnuBusArrivalInfoList("B");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getJnuBusStation().getId());
            System.out.println(list.get(i).getJnuBusStation().getName());
            System.out.println(list.get(i).getJnuBusStation().getOrder());

            System.out.println(list.get(i).getRemainTime().getFirst());
            System.out.println(list.get(i).getRemainTime().getSecond());
        }
    }
}