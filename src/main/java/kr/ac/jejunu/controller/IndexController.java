package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.DepartureSoonBus;
import kr.ac.jejunu.service.BusService;
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
public class IndexController {
    @Autowired
    private BusService busService;

    @RequestMapping(value = "/getDepartureSoonBusList", method = RequestMethod.GET)
    public HashMap<String, DepartureSoonBus> getBeforeDepartureBusList() throws ParseException {
        HashMap<String, DepartureSoonBus> departureSoonBusList =  busService.getDepartureSoonBusList();

        return departureSoonBusList;
    }
}
