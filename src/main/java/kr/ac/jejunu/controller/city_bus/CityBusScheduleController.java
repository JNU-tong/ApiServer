package kr.ac.jejunu.controller.city_bus;


import kr.ac.jejunu.model.response.city_bus.CityBusScheduleResponse;
import kr.ac.jejunu.service.city_bus.CityBusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityBusScheduleController {
    @Autowired
    private CityBusScheduleService cityBusScheduleService;

    @RequestMapping(value = "/getBusScheduleListByLineId/{lineId}", method = RequestMethod.GET)
    public CityBusScheduleResponse getBusScheduleListByLineId(@PathVariable String lineId) {
        CityBusScheduleResponse cityBusScheduleResponse = cityBusScheduleService.getBusScheduleResponseByLineId(lineId);

        return cityBusScheduleResponse;
    }
}
