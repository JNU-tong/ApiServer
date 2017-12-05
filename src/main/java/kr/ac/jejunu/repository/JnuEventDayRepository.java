package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.jpa.main.JnuEventDay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface JnuEventDayRepository  extends CrudRepository<JnuEventDay, Long> {
    @Query(value = "select * from jnu_event_day where date >= CURRENT_DATE order by date ASC limit 1", nativeQuery = true)
    JnuEventDay findFirstByDateIsAfterToday();
}
