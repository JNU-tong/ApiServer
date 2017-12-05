package kr.ac.jejunu.controller.main;

import kr.ac.jejunu.model.jpa.main.JnuEventDay;
import kr.ac.jejunu.service.main.JnuEventDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/jnu/eventDay")
public class JnuEventDayController {
    @Autowired
    private JnuEventDayService jnuEventDayService;

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public JnuEventDay getFirstEventDay() {
        return jnuEventDayService.getFirstEventDay();
    }
}
