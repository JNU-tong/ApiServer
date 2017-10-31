package kr.ac.jejunu.model.response.jnu_bus;

import kr.ac.jejunu.model.jpa.jnu_bus.JnuBusStation;
import kr.ac.jejunu.model.response.RemainTime;

public class JnuBusArrivalInfo {
    private JnuBusStation jnuBusStation;
    private RemainTime remainTime;

    public JnuBusStation getJnuBusStation() {
        return jnuBusStation;
    }

    public void setJnuBusStation(JnuBusStation jnuBusStation) {
        this.jnuBusStation = jnuBusStation;
    }

    public RemainTime getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(RemainTime remainTime) {
        this.remainTime = remainTime;
    }
}