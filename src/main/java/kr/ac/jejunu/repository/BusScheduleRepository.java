package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.jpa.city_bus.CityBusSchedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by Boobby on 17-9-18.
 */
public interface BusScheduleRepository extends CrudRepository<CityBusSchedule, Long> {
    @Query(value = "select * from bus_schedule where departure_time > now() and (weekday_holiday = 'everyday' or weekday_holiday = ?1) order by departure_time ASC", nativeQuery = true)
    ArrayList<CityBusSchedule> findBusSchedulesAfterNow(String weekdayHoliday);

    @Query(value = "select * from bus_schedule where line_id = ?1 and (weekday_holiday = 'everyday' or weekday_holiday = ?2) order by departure_time ASC", nativeQuery = true)
    ArrayList<CityBusSchedule> findBusSchedulesByLineIdWithWeekdayHoliday(String lineId, String weekdayHoliday);

    @Query(value = "select * from bus_schedule where departure_time > now() and line_id = ?1 and (weekday_holiday = 'everyday' or weekday_holiday = ?2) order by departure_time ASC limit 1", nativeQuery = true)
    CityBusSchedule getLatestScheduleByLineId(String lineId, String weekdayHoliday);
}
