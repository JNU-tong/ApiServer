package kr.ac.jejunu.service.jnu_bus;

import kr.ac.jejunu.model.jpa.jnu_bus.JnuBusStation;
import kr.ac.jejunu.repository.JnuBusStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JnuBusStationService {
    @Autowired
    private JnuBusStationRepository jnuBusStationRepository;

    public ArrayList<JnuBusStation> getBusStationList(String course) {
        ArrayList<JnuBusStation> busStationList = jnuBusStationRepository.findAllByOrderByIdAsc();

        if (course.equals("B")) {
            ArrayList<JnuBusStation> reverseList = jnuBusStationRepository.findAllByOrderByIdDesc();
            for (int i = 3; i < busStationList.size() - 3; i++) {
                busStationList.remove(i);
                busStationList.add(i, reverseList.get(i));
            }
        }


        for (int i = 0; i < busStationList.size(); i++) {
            busStationList.get(i).setOrder(i + 1);
        }

        return busStationList;
    }
}
