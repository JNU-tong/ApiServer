package kr.ac.jejunu.model.response;

import kr.ac.jejunu.model.jpa.BusSchedule;

import java.util.ArrayList;

public class BusScheduleResponse {
    private ArrayList<BusSchedule> busScheduleList;
    private BusSchedule latestSchedule;

    public ArrayList<BusSchedule> getBusScheduleList() {
        return busScheduleList;
    }

    public void setBusScheduleList(ArrayList<BusSchedule> busScheduleList) {
        this.busScheduleList = busScheduleList;
    }

    public BusSchedule getLatestSchedule() {
        return latestSchedule;
    }

    public void setLatestSchedule(BusSchedule latestSchedule) {
        this.latestSchedule = latestSchedule;
    }
}
