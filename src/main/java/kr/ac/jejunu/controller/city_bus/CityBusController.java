package kr.ac.jejunu.controller.city_bus;

import kr.ac.jejunu.model.response.city_bus.DepartureSoonCityBus;
import kr.ac.jejunu.service.city_bus.CityBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashMap;

/**
 * Created by Boobby on 17-9-16.
 */
@RestController
public class CityBusController {
    @Autowired
    private CityBusService cityBusService;

    @RequestMapping(value = "/getDepartureSoonBusList", method = RequestMethod.GET)
    public HashMap<String, DepartureSoonCityBus> getBeforeDepartureBusList() throws ParseException {
        System.out.println("/getDepartureSoonBusList request received!!");
        HashMap<String, DepartureSoonCityBus> departureSoonBusList =  cityBusService.getDepartureSoonBusList();

        return departureSoonBusList;
    }
}
