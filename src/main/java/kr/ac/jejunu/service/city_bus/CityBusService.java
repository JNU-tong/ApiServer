package kr.ac.jejunu.service.city_bus;

import kr.ac.jejunu.model.jpa.city_bus.CityBusLineInfo;
import kr.ac.jejunu.model.jpa.city_bus.CityBusSchedule;
import kr.ac.jejunu.model.response.city_bus.DepartureSoonCityBus;
import kr.ac.jejunu.model.response.RemainTime;
import kr.ac.jejunu.repository.city_bus.BusScheduleRepository;
import kr.ac.jejunu.service.generator.TodayService;
import kr.ac.jejunu.service.generator.RemainTimeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Boobby on 17-9-18.
 */
@Service
public class CityBusService {
    @Autowired
    private BusScheduleRepository busScheduleRepository;

    @Autowired
    private TodayService todayService;

    public HashMap<String, DepartureSoonCityBus> getDepartureSoonBusList() {
        ArrayList<CityBusSchedule> departureSoonBuses = busScheduleRepository.findBusSchedulesAfterNow(todayService.whatDayToday().name());

        HashMap<String, DepartureSoonCityBus> departureSoonBusList = new HashMap<>();

        for (CityBusSchedule departureSoonBus : departureSoonBuses) {
            int remainTime = RemainTimeGenerator.getRemainTime(departureSoonBus.getDepartureTime());

            CityBusLineInfo cityBusLineInfo = departureSoonBus.getCityBusLineInfo();

            if (!departureSoonBusList.containsKey(cityBusLineInfo.getLineId())) {
                DepartureSoonCityBus newBus = new DepartureSoonCityBus(cityBusLineInfo, new RemainTime(remainTime, null));
                departureSoonBusList.put(cityBusLineInfo.getLineId(), newBus);
            } else if (departureSoonBusList.get(cityBusLineInfo.getLineId()).getRemainTime().getSecond() == null) {
                departureSoonBusList.get(cityBusLineInfo.getLineId()).getRemainTime().setSecond(remainTime);
            }
        }

        return departureSoonBusList;
    }


}
