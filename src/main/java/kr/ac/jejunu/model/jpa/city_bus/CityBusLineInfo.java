package kr.ac.jejunu.model.jpa.city_bus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Boobby on 17-9-18.
 */
@Entity(name = "bus_line_info")
public class CityBusLineInfo {
    @Id
    @Column(name = "line_id", nullable = false, length = 12)
    private String lineId;

    @Column(name = "line_no", nullable = false, length = 7)
    private String lineNo;

    @Column(name = "detail_line_no", nullable = false, length = 5)
    private String detailLineNo;

    @Column(name = "description", nullable = false, length = 30)
    private String description;

//    @OneToMany(mappedBy = "bus_line_info")
//    List<CityBusSchedule> busScheduleList = new ArrayList<>();

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getLineNo() {
        return lineNo;
    }

    public void setLineNo(String lineNo) {
        this.lineNo = lineNo;
    }

    public String getDetailLineNo() {
        return detailLineNo;
    }

    public void setDetailLineNo(String detailLineNo) {
        this.detailLineNo = detailLineNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<CityBusSchedule> getBusScheduleList() {
//        return busScheduleList;
//    }
//
//    public void setBusScheduleList(List<CityBusSchedule> busScheduleList) {
//        this.busScheduleList = busScheduleList;
//    }
}
