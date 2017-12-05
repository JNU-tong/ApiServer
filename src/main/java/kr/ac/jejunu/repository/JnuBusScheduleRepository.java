package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.enm.JnuBusCourse;
import kr.ac.jejunu.model.jpa.jnu_bus.JnuBusSchedule;
import kr.ac.jejunu.model.jpa.jnu_bus.JnuBusStation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface JnuBusScheduleRepository extends CrudRepository<JnuBusSchedule, Long> {
    @Query(value = "select * from jnu_bus_schedule where departure_time > now() and course = ?1 order by departure_time ASC", nativeQuery = true)
    ArrayList<JnuBusSchedule> findAllByDepartureTimeAfter(String course);

    ArrayList<JnuBusSchedule> findAllByCourse(JnuBusCourse course);
}
