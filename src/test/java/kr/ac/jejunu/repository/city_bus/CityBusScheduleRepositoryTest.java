package kr.ac.jejunu.repository.city_bus;

import kr.ac.jejunu.model.enm.WeekdayHoliday;
import kr.ac.jejunu.model.jpa.city_bus.CityBusLineInfo;
import kr.ac.jejunu.model.jpa.city_bus.CityBusSchedule;
import kr.ac.jejunu.service.generator.RemainTimeGenerator;
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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CityBusScheduleRepositoryTest {
    @Autowired
    private CityBusScheduleRepository cityBusScheduleRepository;

    @Autowired
    private CityBusLineInfoRepository cityBusLineInfoRepository;

    @Autowired
    private SimpleDateFormat dateFormat;

    @Test
    public void findOneTest() throws ParseException {
        Long scheduleNo = 1L;
        String lineId = "JEB405134001";
        CityBusLineInfo cityBusLineInfo = cityBusLineInfoRepository.findOne(lineId);

        Date departureTime = dateFormat.parse("06:00:00");
        WeekdayHoliday weekdayHoliday = WeekdayHoliday.weekday;

        CityBusSchedule schedule = cityBusScheduleRepository.findOne(scheduleNo);

        assertThat(schedule.getScheduleNo(), is(scheduleNo));
        assertThat(schedule.getCityBusLineInfo(), is(cityBusLineInfo));
        assertThat(schedule.getDepartureTime(), is(departureTime));
        assertThat(schedule.getWeekdayHoliday(), is(weekdayHoliday));
    }

    @Test
    public void findAllTest() {
        final int NUM_OF_SCHEDULES = 803;

        ArrayList<CityBusSchedule> list = (ArrayList<CityBusSchedule>) cityBusScheduleRepository.findAll();

        assertThat(list.size(), is(NUM_OF_SCHEDULES));
    }

    @Test
    public void addTest() throws ParseException {
        // Id 가 Generated Value 라서 Id 값은 제외하고 입력

        String lineId = "JEB405134001";
        CityBusLineInfo busLineInfo = cityBusLineInfoRepository.findOne(lineId);
        Date departureTime = dateFormat.parse("11:11:11");
        WeekdayHoliday weekdayHoliday = WeekdayHoliday.holiday;

        CityBusSchedule schedule = new CityBusSchedule();
        schedule.setCityBusLineInfo(busLineInfo);
        schedule.setDepartureTime(departureTime);
        schedule.setWeekdayHoliday(weekdayHoliday);

        CityBusSchedule newSchedule = cityBusScheduleRepository.save(schedule);

        assertThat(newSchedule.getCityBusLineInfo(), is(busLineInfo));
        assertThat(newSchedule.getDepartureTime(), is(departureTime));
        assertThat(newSchedule.getWeekdayHoliday(), is(weekdayHoliday));
    }
}