package kr.ac.jejunu.service.city_bus;

import kr.ac.jejunu.model.jpa.city_bus.CityBusSchedule;
import kr.ac.jejunu.model.response.city_bus.BusScheduleResponse;
import kr.ac.jejunu.repository.BusScheduleRepository;
import kr.ac.jejunu.service.generator.TodayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BusScheduleService {
    @Autowired
    private BusScheduleRepository busScheduleRepository;

    @Autowired
    private TodayService todayService;

    public BusScheduleResponse getBusScheduleResponseByLineId(String lineId) {

        ArrayList<CityBusSchedule> cityBusSchedules = busScheduleRepository.findBusSchedulesByLineIdWithWeekdayHoliday(lineId, todayService.whatDayToday().name());
        CityBusSchedule latestSchedule = busScheduleRepository.getLatestScheduleByLineId(lineId, todayService.whatDayToday().name());


        BusScheduleResponse busScheduleResponse = new BusScheduleResponse(cityBusSchedules, latestSchedule);

        return busScheduleResponse;
    }
}