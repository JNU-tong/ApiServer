package kr.ac.jejunu.service;

import kr.ac.jejunu.model.enm.WeekdayHoliday;
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

    public BusScheduleResponse getBusScheduleResponseByLineId(String lineId) {
        BusScheduleResponse busScheduleResponse = new BusScheduleResponse();

        ArrayList<BusSchedule> busSchedules = busScheduleRepository.findBusSchedulesByBusLineInfo_LineIdAndAndWeekdayHoliday(lineId, WeekdayHoliday.weekday);
        busScheduleResponse.setBusScheduleList(busSchedules);

        BusSchedule latestSchedule = busScheduleRepository.getLatestScheduleByLineId(lineId, WeekdayHoliday.weekday.name());

        busScheduleResponse.setLatestSchedule(latestSchedule);

        return busScheduleResponse;
    }
}