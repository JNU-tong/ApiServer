package kr.ac.jejunu.service.main;

import kr.ac.jejunu.model.jpa.main.JnuEventDay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JnuEventDayServiceTest {
    @Autowired
    private JnuEventDayService jnuEventDayService;

    @Test
    public void getFirstEventDayTest() {
        JnuEventDay eventDay = new JnuEventDay();

        Date today = new Date();
        String event = "test";

        eventDay.setDate(today);
        eventDay.setEvent(event);

        jnuEventDayService.addEventDay(eventDay);

        JnuEventDay firstEventDay = jnuEventDayService.getFirstEventDay();

        assertThat(firstEventDay.getdDay(), is(0));
    }
}