package kr.ac.jejunu.model.response;

import kr.ac.jejunu.model.enm.JnuBusCourse;
import kr.ac.jejunu.model.jpa.jnu_bus.JnuBusStation;

public class JnuBusArrivalInfo {
    private JnuBusStation jnuBusStation;
    private JnuBusCourse course;
    private RemainTime remainTime;

    public JnuBusStation getJnuBusStation() {
        return jnuBusStation;
    }

    public void setJnuBusStation(JnuBusStation jnuBusStation) {
        this.jnuBusStation = jnuBusStation;
    }

    public JnuBusCourse getCourse() {
        return course;
    }

    public void setCourse(JnuBusCourse course) {
        this.course = course;
    }

    public RemainTime getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(RemainTime remainTime) {
        this.remainTime = remainTime;
    }
}
