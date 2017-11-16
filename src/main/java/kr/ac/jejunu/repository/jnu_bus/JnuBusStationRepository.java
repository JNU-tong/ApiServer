package kr.ac.jejunu.repository.jnu_bus;

import kr.ac.jejunu.model.jpa.jnu_bus.JnuBusStation;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface JnuBusStationRepository extends CrudRepository<JnuBusStation, Integer> {
    ArrayList<JnuBusStation> findAllByOrderByIdAsc();
    ArrayList<JnuBusStation> findAllByOrderByIdDesc();
}
