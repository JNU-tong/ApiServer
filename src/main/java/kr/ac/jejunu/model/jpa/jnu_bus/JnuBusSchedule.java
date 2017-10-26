package kr.ac.jejunu.model.jpa.jnu_bus;

import kr.ac.jejunu.model.enm.JnuBusCourse;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "jnu_bus_schedule")
public class JnuBusSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Temporal(value = TemporalType.TIME)
    @Column(name = "departure_time", nullable = false)
    private Date departureTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "course", nullable = false)
    private JnuBusCourse course;

    @Column(name = "go_ocean_science", nullable = false)
    private boolean goOceanScience;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public JnuBusCourse getCourse() {
        return course;
    }

    public void setCourse(JnuBusCourse course) {
        this.course = course;
    }

    public boolean isGoOceanScience() {
        return goOceanScience;
    }

    public void setGoOceanScience(boolean goOceanScience) {
        this.goOceanScience = goOceanScience;
    }
}
