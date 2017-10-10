package kr.ac.jejunu.model.response;

import kr.ac.jejunu.model.enm.WeekdayHoliday;
import kr.ac.jejunu.model.jpa.BusSchedule;
import kr.ac.jejunu.service.generator.RemainTimeGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;

public class BusScheduleResponse {
    private ArrayList<BusScheduleAndRemainTime> busScheduleList;
    private BusScheduleAndRemainTime latestSchedule;

    public BusScheduleResponse(ArrayList<BusSchedule> busSchedules, BusSchedule latestSchedule) {
        this.busScheduleList = new ArrayList<>();
        this.latestSchedule = new BusScheduleAndRemainTime();

        this.setBusScheduleList(busSchedules);
        this.setLatestSchedule(latestSchedule);
    }

    public ArrayList<BusScheduleAndRemainTime> getBusScheduleList() {
        return busScheduleList;
    }

    public void setBusScheduleList(ArrayList<BusSchedule> busScheduleList) {

        for (BusSchedule schedule : busScheduleList) {
            BusScheduleAndRemainTime newSchedule = new BusScheduleAndRemainTime();
            newSchedule.setScheduleNo(schedule.getScheduleNo());
            newSchedule.setDepartureTime(schedule.getDepartureTime());
            newSchedule.setRemainTime(RemainTimeGenerator.getRemainTime(schedule.getDepartureTime()));
            newSchedule.setWeekdayHoliday(schedule.getWeekdayHoliday());

            this.busScheduleList.add(newSchedule);
        }
    }

    public BusScheduleAndRemainTime getLatestSchedule() {
        return latestSchedule;
    }

    public void setLatestSchedule(BusSchedule latestSchedule) {
        this.latestSchedule.setScheduleNo(latestSchedule.getScheduleNo());
        this.latestSchedule.setDepartureTime(latestSchedule.getDepartureTime());
        this.latestSchedule.setRemainTime(RemainTimeGenerator.getRemainTime(latestSchedule.getDepartureTime()));
        this.latestSchedule.setWeekdayHoliday(latestSchedule.getWeekdayHoliday());
    }

    protected class BusScheduleAndRemainTime {
        private Long scheduleNo;
        private Date departureTime;
        private Integer remainTime;
        private WeekdayHoliday weekdayHoliday;

        public Long getScheduleNo() {
            return scheduleNo;
        }

        public void setScheduleNo(Long scheduleNo) {
            this.scheduleNo = scheduleNo;
        }

        public Date getDepartureTime() {
            return departureTime;
        }

        public void setDepartureTime(Date departureTime) {
            this.departureTime = departureTime;
        }

        public Integer getRemainTime() {
            return remainTime;
        }

        public void setRemainTime(Integer remainTime) {
            this.remainTime = remainTime;
        }

        public WeekdayHoliday getWeekdayHoliday() {
            return weekdayHoliday;
        }

        public void setWeekdayHoliday(WeekdayHoliday weekdayHoliday) {
            this.weekdayHoliday = weekdayHoliday;
        }
    }
}
