package kr.ac.jejunu.service;

import kr.ac.jejunu.model.enm.WeekdayHoliday;
import kr.ac.jejunu.model.jpa.BusLineInfo;
import kr.ac.jejunu.model.jpa.BusSchedule;
import kr.ac.jejunu.model.response.DepartureSoonBus;
import kr.ac.jejunu.model.response.RemainTime;
import kr.ac.jejunu.repository.BusLineInfoRepository;
import kr.ac.jejunu.repository.BusScheduleRepository;
import kr.ac.jejunu.service.generator.RemainTimeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Boobby on 17-9-18.
 */
@Service
public class BusService {
    @Autowired
    private BusScheduleRepository busScheduleRepository;

    @Autowired
    private TodayService todayService;

    public HashMap<String, DepartureSoonBus> getDepartureSoonBusList() {
        ArrayList<BusSchedule> departureSoonBuses = busScheduleRepository.findBusSchedulesAfterNow(todayService.whatDayToday().name());

        HashMap<String, DepartureSoonBus> departureSoonBusList = new HashMap<>();

        for (BusSchedule departureSoonBus : departureSoonBuses) {
            int remainTime = RemainTimeGenerator.getRemainTime(departureSoonBus.getDepartureTime());

            BusLineInfo busLineInfo = departureSoonBus.getBusLineInfo();

            if (!departureSoonBusList.containsKey(busLineInfo.getLineId())) {
                DepartureSoonBus newBus = new DepartureSoonBus(busLineInfo, new RemainTime.RemainTimeBuilder(remainTime, null).build());
                departureSoonBusList.put(busLineInfo.getLineId(), newBus);
            } else if (departureSoonBusList.get(busLineInfo.getLineId()).getRemainTime().getSecond() == null) {
                departureSoonBusList.get(busLineInfo.getLineId()).getRemainTime().setSecond(remainTime);
            }
        }

        return departureSoonBusList;
    }


}
