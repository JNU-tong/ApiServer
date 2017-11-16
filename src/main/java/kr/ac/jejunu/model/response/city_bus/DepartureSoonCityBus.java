package kr.ac.jejunu.model.response.city_bus;

import kr.ac.jejunu.model.jpa.city_bus.CityBusLineInfo;
import kr.ac.jejunu.model.response.RemainTime;

public class DepartureSoonCityBus {
    private CityBusLineInfo cityBusLineInfo;

    private RemainTime remainTime;

    public DepartureSoonCityBus(CityBusLineInfo cityBusLineInfo, RemainTime remainTime) {
        this.cityBusLineInfo = cityBusLineInfo;
        this.remainTime = remainTime;
    }

    public CityBusLineInfo getCityBusLineInfo() {
        return cityBusLineInfo;
    }

    public void setCityBusLineInfo(CityBusLineInfo cityBusLineInfo) {
        this.cityBusLineInfo = cityBusLineInfo;
    }

    public RemainTime getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(RemainTime remainTime) {
        this.remainTime = remainTime;
    }
}
