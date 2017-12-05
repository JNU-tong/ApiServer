package kr.ac.jejunu.service.main;

import kr.ac.jejunu.model.jpa.main.JnuEventDay;
import kr.ac.jejunu.repository.JnuEventDayRepository;
import kr.ac.jejunu.service.generator.RemainTimeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JnuEventDayService {
    @Autowired
    private JnuEventDayRepository jnuEventDayRepository;

    public JnuEventDay getFirstEventDay() {
        JnuEventDay firstEventDay = jnuEventDayRepository.findFirstByDateIsAfterToday();
        Integer dDay = RemainTimeGenerator.getRemainDay(firstEventDay.getDate());
        firstEventDay.setdDay(dDay);

        return firstEventDay;
    }

    public void addEventDay(JnuEventDay eventDay) {
        jnuEventDayRepository.save(eventDay);
    }
}
