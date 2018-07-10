package kr.ac.jejunu.model.jpa.main;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "jnu_event_day")
public class JnuEventDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "event", nullable = false)
    private String event;

    @Transient
    private Integer dDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Integer getdDay() {
        return dDay;
    }

    public void setdDay(Integer dDay) {
        this.dDay = dDay;
    }

    @Override
    public String toString() {
        return "JnuEventDay{" +
                "id=" + id +
                ", date=" + date +
                ", event='" + event + '\'' +
                ", dDay=" + dDay +
                '}';
    }
}
