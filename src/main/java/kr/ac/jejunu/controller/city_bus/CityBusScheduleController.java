package kr.ac.jejunu.controller.city_bus;


import kr.ac.jejunu.model.response.BusScheduleResponse;
import kr.ac.jejunu.service.city_bus.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityBusScheduleController {
    @Autowired
    private BusScheduleService busScheduleService;

    @RequestMapping(value = "/getBusScheduleListByLineId/{lineId}", method = RequestMethod.GET)
    public BusScheduleResponse getBusScheduleListByLineId(@PathVariable String lineId) {
        BusScheduleResponse busScheduleResponse = busScheduleService.getBusScheduleResponseByLineId(lineId);

        return busScheduleResponse;
    }
}
