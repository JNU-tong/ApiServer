package kr.ac.jejunu.model.jpa;

import kr.ac.jejunu.model.enm.WeekdayHoliday;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Boobby on 17-9-18.
 */
@Entity(name = "bus_schedule")
public class BusSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_no")
    private Long scheduleNo;

    @ManyToOne
    @JoinColumn(name = "line_id", nullable = false)
    private BusLineInfo busLineInfo;

    @Temporal(value = TemporalType.TIME)
    @Column(name = "departure_time", nullable = false)
    private Date departureTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "weekday_holiday", nullable = false)
    private WeekdayHoliday weekdayHoliday;

    public Long getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(Long scheduleNo) {
        this.scheduleNo = scheduleNo;
    }

    public BusLineInfo getBusLineInfo() {
        return busLineInfo;
    }

    public void setBusLineInfo(BusLineInfo busLineInfo) {
        this.busLineInfo = busLineInfo;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public WeekdayHoliday getWeekdayHoliday() {
        return weekdayHoliday;
    }

    public void setWeekdayHoliday(WeekdayHoliday weekdayHoliday) {
        this.weekdayHoliday = weekdayHoliday;
    }
}
