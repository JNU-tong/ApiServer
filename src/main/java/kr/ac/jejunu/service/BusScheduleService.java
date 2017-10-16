package kr.ac.jejunu.service;

import kr.ac.jejunu.model.jpa.BusSchedule;
import kr.ac.jejunu.model.response.BusScheduleResponse;
import kr.ac.jejunu.repository.BusScheduleRepository;
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

        ArrayList<BusSchedule> busSchedules = busScheduleRepository.findBusSchedulesByLineIdWithWeekdayHoliday(lineId, todayService.whatDayToday().name());
        BusSchedule latestSchedule = busScheduleRepository.getLatestScheduleByLineId(lineId, todayService.whatDayToday().name());


        BusScheduleResponse busScheduleResponse = new BusScheduleResponse(busSchedules, latestSchedule);

        return busScheduleResponse;
    }
}