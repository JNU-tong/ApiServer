package kr.ac.jejunu.service;

import kr.ac.jejunu.model.enm.WeekdayHoliday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TodayService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${eventDayApi.TDCProjectKey}")
    private String TDCProjectKey;

    @Value("${eventDayApi.url}")
    private String url;

    private String lastUpdatedDate;
    private WeekdayHoliday lastDay;

    public TodayService() {
        lastUpdatedDate = "00000000";
        lastDay = WeekdayHoliday.holiday;
    }

    public WeekdayHoliday whatDayToday() {
        if (isHoliday() || isWeekend())
            return WeekdayHoliday.holiday;
        else
            return WeekdayHoliday.weekday;
    }

    private boolean isHoliday() {
        // Today
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String fullDate = dateFormat.format(today);

        // if last updated date equals today, will not check again.
        if (!lastUpdatedDate.equals(fullDate)) {
            try {
                lastUpdatedDate = fullDate;

                String year = fullDate.substring(0, 4);
                String month = fullDate.substring(4, 6);
                String day = fullDate.substring(6);

                URI requestUrl = UriComponentsBuilder.newInstance()
                        .scheme("https")
                        .host(url)
                        .queryParam("TDCProjectKey", URLDecoder.decode(TDCProjectKey, "UTF-8"))
                        .queryParam("type", "")
                        .queryParam("year", year)
                        .queryParam("month", month)
                        .queryParam("day", day)
                        .build()
                        .toUri();

                String response = restTemplate.getForObject(requestUrl, String.class);

                System.out.println(response);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private boolean isWeekend() {

        return true;
    }


}
