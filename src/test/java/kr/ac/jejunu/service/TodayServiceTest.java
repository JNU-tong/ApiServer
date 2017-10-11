package kr.ac.jejunu.service;

import kr.ac.jejunu.model.enm.WeekdayHoliday;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodayServiceTest {
    @Autowired
    private TodayService todayService;

//    @Test
//    public void test1() throws ParseException {
//        todayService.whatDay("20171005");
//        assertThat(todayService.getToday(), is("20171005"));
//        assertThat(todayService.whatDayToday(), is(WeekdayHoliday.holiday));
//    }
//
//    @Test
//    public void test2() throws ParseException {
//        todayService.whatDayToday();
//        assertThat(todayService.whatDayToday(), is(WeekdayHoliday.weekday));
//    }
//
//    @Test
//    public void test3() throws ParseException {
//        todayService.whatDay("20171014");
//        assertThat(todayService.getToday(), is("20171014"));
//        assertThat(todayService.whatDayToday(), is(WeekdayHoliday.holiday));
//    }
}