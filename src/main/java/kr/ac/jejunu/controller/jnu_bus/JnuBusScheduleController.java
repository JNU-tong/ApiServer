package kr.ac.jejunu.controller.jnu_bus;

import kr.ac.jejunu.model.response.RemainTime;
import kr.ac.jejunu.model.response.jnu_bus.JnuBusArrivalInfo;
import kr.ac.jejunu.service.jnu_bus.JnuBusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class JnuBusScheduleController {
    @Autowired
    private JnuBusScheduleService jnuBusScheduleService;

    @RequestMapping(value = "/getJnuBusArrivalInfoListByCourse", method = RequestMethod.GET)
    public ArrayList<JnuBusArrivalInfo> getJnuBusArrivalInfoListByCourse(String course) {
        return jnuBusScheduleService.getJnuBusArrivalInfoList(course);
    }

    @RequestMapping(value = "/getJnuBusArrivalInfoByStationId", method = RequestMethod.GET)
    public HashMap<String, RemainTime> getJnuBusArrivalInfoListByCourse(int stationId) {
        return jnuBusScheduleService.getRemainTimeOfStationAllCourse(stationId);
    }
}
