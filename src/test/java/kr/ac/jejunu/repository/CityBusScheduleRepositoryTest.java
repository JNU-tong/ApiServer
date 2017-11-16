package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.enm.WeekdayHoliday;
import kr.ac.jejunu.model.jpa.city_bus.CityBusSchedule;
import kr.ac.jejunu.repository.city_bus.BusScheduleRepository;
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
public class CityBusScheduleRepositoryTest {
    @Autowired
    private BusScheduleRepository busScheduleRepository;

    @Test
    public void test1() throws ParseException {
        ArrayList<CityBusSchedule> cityBusScheduleArrayList = busScheduleRepository.findBusSchedulesAfterNow("weekday");
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        now = dateFormat.parse(dateFormat.format(now));

        for (CityBusSchedule cityBusSchedule : cityBusScheduleArrayList) {
            System.out.println((cityBusSchedule.getDepartureTime().getTime() - now.getTime()) / 60000);
        }
    }

    @Test
    public void findBusSchedulesByBusLineInfo_LineIdAndAndWeekdayHolidayTest() {
        ArrayList<CityBusSchedule> list = busScheduleRepository.findBusSchedulesByLineIdWithWeekdayHoliday("JEB405134502", WeekdayHoliday.weekday.name());

        for (CityBusSchedule schedule : list) {
            System.out.println(schedule.getScheduleNo());
            System.out.println(schedule.getWeekdayHoliday());
            System.out.println(schedule.getDepartureTime());
        }
    }

}
