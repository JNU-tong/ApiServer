package kr.ac.jejunu.controller.jnu_bus;

import kr.ac.jejunu.model.jpa.jnu_bus.JnuBusStation;
import kr.ac.jejunu.service.jnu_bus.JnuBusStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class JnuBusStationController {
    @Autowired
    private JnuBusStationService jnuBusStationService;

    @RequestMapping(value = "/getJnuBusStationList", method = RequestMethod.GET)
    public ArrayList<JnuBusStation> getJnuBusStationList(String course) {
        return jnuBusStationService.getBusStationList(course);
    }
}
