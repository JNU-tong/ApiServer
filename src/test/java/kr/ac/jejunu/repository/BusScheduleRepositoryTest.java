package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.jpa.BusSchedule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BusScheduleRepositoryTest {
    @Autowired
    private BusScheduleRepository busScheduleRepository;

    @Test
    public void test1() throws ParseException {
        ArrayList<BusSchedule> busScheduleArrayList = busScheduleRepository.findBusSchedulesAfterNow("weekday");
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        now = dateFormat.parse(dateFormat.format(now));

        for (BusSchedule busSchedule : busScheduleArrayList) {
            System.out.println((busSchedule.getDepartureTime().getTime() - now.getTime()) / 60000);
        }
    }

}