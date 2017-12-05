package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.jpa.main.JnuEventDay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JnuEventDayRepositoryTest {
    @Autowired
    private JnuEventDayRepository jnuEventDayRepository;

    @Test
    public void saveTest() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 3, 1);
        Date date = calendar.getTime();
        String text = "개강";

        JnuEventDay eventDay = new JnuEventDay();
        eventDay.setDate(date);
        eventDay.setEvent(text);

        JnuEventDay savedEventDay = jnuEventDayRepository.save(eventDay);

        assertThat(savedEventDay.getDate(), is(date));
        assertThat(savedEventDay.getEvent(), is(text));
    }

    @Test
    public void findFirstByDateIsTodayTest() {
        Date date = new Date(); // today
        String text = "test";

        JnuEventDay eventDay = new JnuEventDay();
        eventDay.setDate(date);
        eventDay.setEvent(text);

        jnuEventDayRepository.save(eventDay);

        JnuEventDay firstEventDay = jnuEventDayRepository.findFirstByDateIsAfterToday();

        assertThat(firstEventDay.getDate(), is(date));
        assertThat(firstEventDay.getEvent(), is(text));
    }
}