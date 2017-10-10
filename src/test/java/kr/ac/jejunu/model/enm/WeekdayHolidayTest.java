package kr.ac.jejunu.model.enm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WeekdayHolidayTest {
    @Test
    public void whatDayTodayTest() throws ParserConfigurationException, SAXException, IOException {
        WeekdayHoliday.whatDayToday();
    }

}