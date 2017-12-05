package kr.ac.jejunu.model.jpa.main;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "jnu_event_day")
public class JnuEventDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    private Date date;
    private String text;
    private Integer dDay;
}
