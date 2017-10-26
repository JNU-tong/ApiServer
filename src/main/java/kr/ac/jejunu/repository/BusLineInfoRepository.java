package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.jpa.city_bus.CityBusLineInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Boobby on 17-9-18.
 */
public interface BusLineInfoRepository extends CrudRepository<CityBusLineInfo, String> {
}
