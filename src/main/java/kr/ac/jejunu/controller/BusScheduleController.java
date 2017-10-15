package kr.ac.jejunu.controller;


import kr.ac.jejunu.model.jpa.BusSchedule;
import kr.ac.jejunu.model.response.BusScheduleResponse;
import kr.ac.jejunu.service.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class BusScheduleController {
    @Autowired
    private BusScheduleService busScheduleService;

    @RequestMapping(value = "/getBusScheduleListByLineId/{lineId}", method = RequestMethod.GET)
    public BusScheduleResponse getBusScheduleListByLineId(@PathVariable String lineId) {
        BusScheduleResponse busScheduleResponse = busScheduleService.getBusScheduleResponseByLineId(lineId);

        return busScheduleResponse;
    }
}
