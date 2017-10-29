package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.jpa.jnu_bus.JnuBusSchedule;
import kr.ac.jejunu.model.jpa.jnu_bus.JnuBusStation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface JnuBusScheduleRepository extends CrudRepository<JnuBusSchedule, Long> {
    @Query(value = "select * from jnu_bus_schedule where departure_time > now() and course = ?1 order by departure_time ASC", nativeQuery = true)
    ArrayList<JnuBusSchedule> findAllByDepartureTimeAfter(String course);
    // departure_time 에 (order - 1)분 더하면 도착 예정 시간이니까
    // 더하고 departure_time 이랑 now() 비교, 위에서 2개만 가져오기(limit 이였나?)

    // A코스랑 B코스 둘다 Station 에 넣고 줄까..?
}
