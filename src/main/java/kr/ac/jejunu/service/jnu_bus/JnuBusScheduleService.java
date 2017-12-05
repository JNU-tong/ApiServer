package kr.ac.jejunu.service.jnu_bus;

import kr.ac.jejunu.model.enm.JnuBusCourse;
import kr.ac.jejunu.model.enm.WeekdayHoliday;
import kr.ac.jejunu.model.jpa.jnu_bus.JnuBusSchedule;
import kr.ac.jejunu.model.jpa.jnu_bus.JnuBusStation;
import kr.ac.jejunu.model.response.RemainTime;
import kr.ac.jejunu.model.response.jnu_bus.JnuBusArrivalInfo;
import kr.ac.jejunu.repository.JnuBusScheduleRepository;
import kr.ac.jejunu.service.generator.TodayService;
import kr.ac.jejunu.service.generator.RemainTimeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class JnuBusScheduleService {
    @Autowired
    private JnuBusScheduleRepository jnuBusScheduleRepository;

    @Autowired
    private TodayService todayService;

    @Autowired
    private JnuBusStationService jnuBusStationService;

    public ArrayList<JnuBusArrivalInfo> getJnuBusArrivalInfoList(String course) {
        ArrayList<JnuBusArrivalInfo> jnuBusArrivalInfoArrayList = new ArrayList<>();

        ArrayList<JnuBusStation> jnuBusStations = jnuBusStationService.getBusStationList(course);

        for (int i = 0; i < jnuBusStations.size(); i++) {
            JnuBusArrivalInfo busArrivalInfo = new JnuBusArrivalInfo();

            RemainTime remainTime = getRemainTimeOfStationByCourse(course, i + 1);

            busArrivalInfo.setJnuBusStation(jnuBusStations.get(i));
            busArrivalInfo.setRemainTime(remainTime);

            jnuBusArrivalInfoArrayList.add(busArrivalInfo);
        }
        return jnuBusArrivalInfoArrayList;
    }

    public HashMap<String, RemainTime> getRemainTimeOfStationAllCourse(Integer stationId) {
        HashMap<String, RemainTime> arrivalInfo = new HashMap<>();

        ArrayList<JnuBusStation> bCourseList = jnuBusStationService.getBusStationList("B");
        int bOrder = 0;
        for (int i = 0; i < bCourseList.size(); i++) {
            if (bCourseList.get(i).getId() == stationId) {
                bOrder = bCourseList.get(i).getOrder();
                break;
            }
        }

        RemainTime aCourse = getRemainTimeOfStationByCourse("A", stationId);
        RemainTime bCourse = getRemainTimeOfStationByCourse("B", bOrder);

        arrivalInfo.put("A", aCourse);
        arrivalInfo.put("B", bCourse);

        return arrivalInfo;
    }

    public ArrayList<JnuBusSchedule> getJnuBusScheduleListByCourse(String course) {
        ArrayList<JnuBusSchedule> jnuBusScheduleArrayList = jnuBusScheduleRepository.findAllByCourse(JnuBusCourse.valueOf(course));

        return jnuBusScheduleArrayList;
    }

    public RemainTime getRemainTimeOfStationByCourse(String course, Integer order) {
        ArrayList<JnuBusSchedule> jnuBusScheduleArrayList = getJnuBusScheduleListByCourse(course);

        RemainTime remainTime = new RemainTime(null, null);
        if (todayService.whatDayToday() == WeekdayHoliday.weekday) {
            if ((order == 12 && course.equals("A")) || (order == 5 && course.equals("B"))) {
                for (int i = 0; i < jnuBusScheduleArrayList.size(); i++) {
                    int time = -1;

                    if (jnuBusScheduleArrayList.get(i).isGoOceanScience())
                        time = RemainTimeGenerator.getRemainTime(jnuBusScheduleArrayList.get(i).getDepartureTime()) + order - 1;

                    if (time > 0 && remainTime.getFirst() == null) remainTime.setFirst(time);
                    else if (time > 0 && remainTime.getSecond() == null) {
                        remainTime.setSecond(time);
                        break;
                    }
                }
            } else {
                for (int i = 0; i < jnuBusScheduleArrayList.size(); i++) {
                    int time;

                    if (order > 12 && course.equals("A") && !jnuBusScheduleArrayList.get(i).isGoOceanScience()) {
                        time = RemainTimeGenerator.getRemainTime(jnuBusScheduleArrayList.get(i).getDepartureTime()) + order - 2;
                    } else if (order > 5 && course.equals("B") && !jnuBusScheduleArrayList.get(i).isGoOceanScience()) {
                        time = RemainTimeGenerator.getRemainTime(jnuBusScheduleArrayList.get(i).getDepartureTime()) + order - 2;
                    } else
                        time = RemainTimeGenerator.getRemainTime(jnuBusScheduleArrayList.get(i).getDepartureTime()) + order - 1;

                    if (time > 0 && remainTime.getFirst() == null) remainTime.setFirst(time);
                    else if (time > 0 && remainTime.getSecond() == null) {
                        remainTime.setSecond(time);
                        break;
                    }
                }
            }
        }

        return remainTime;
    }
}
