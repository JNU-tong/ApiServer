package kr.ac.jejunu.service;

import kr.ac.jejunu.model.*;
import kr.ac.jejunu.repository.BusLineInfoRepository;
import kr.ac.jejunu.repository.BusScheduleRepository;
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
    private BusLineInfoRepository busLineInfoRepository;

    @Autowired
    private BusScheduleRepository busScheduleRepository;

    public HashMap<String, DepartureSoonBus> getDepartureSoonBusList() throws ParseException {
        ArrayList<BusSchedule> departureSoonBuses = busScheduleRepository.findBusSchedulesAfterNow(WeekdayHoliday.weekday.name());

        HashMap<String, DepartureSoonBus> departureSoonBusList = new HashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date current = new Date();
        current = dateFormat.parse(dateFormat.format(current));
        Long currentTIme = current.getTime();


        for (BusSchedule departureSoonBus : departureSoonBuses) {
            int remainTime = (int) ((departureSoonBus.getDepartureTime().getTime() - currentTIme) / 60000);

            BusLineInfo busLineInfo = departureSoonBus.getBusLineInfo();

            if (!departureSoonBusList.containsKey(busLineInfo.getLineId())) {
                DepartureSoonBus newBus = new DepartureSoonBus(busLineInfo, new RemainTime.RemainTimeBuilder(remainTime, null).build());
                departureSoonBusList.put(busLineInfo.getLineId(), newBus);
            } else if (departureSoonBusList.get(busLineInfo.getLineId()).getRemainTime().getSecond() == null) {
//                DepartureSoonBus updateBus = new DepartureSoonBus(busLineInfo, new RemainTime.RemainTimeBuilder(departureSoonBusList.get(busLineInfo.getLineId()).getRemainTime().getFirst(), remainTime).build());
//                departureSoonBusList.put(busLineInfo.getLineId(), updateBus);

                departureSoonBusList.get(busLineInfo.getLineId()).setRemainTime(new RemainTime.RemainTimeBuilder(departureSoonBusList.get(busLineInfo.getLineId()).getRemainTime().getFirst(), remainTime).build());
            }
        }

        return departureSoonBusList;
    }


}
