package kr.ac.jejunu.model;

public class DepartureSoonBus {
    private BusLineInfo busLineInfo;

    private RemainTime remainTime;

    public DepartureSoonBus(BusLineInfo busLineInfo, RemainTime remainTime) {
        this.busLineInfo = busLineInfo;
        this.remainTime = remainTime;
    }

    public BusLineInfo getBusLineInfo() {
        return busLineInfo;
    }

    public void setBusLineInfo(BusLineInfo busLineInfo) {
        this.busLineInfo = busLineInfo;
    }

    public RemainTime getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(RemainTime remainTime) {
        this.remainTime = remainTime;
    }
}
