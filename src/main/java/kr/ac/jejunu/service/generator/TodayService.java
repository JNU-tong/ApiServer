package kr.ac.jejunu.service.generator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ac.jejunu.model.enm.WeekdayHoliday;
import kr.ac.jejunu.model.response.EventDayInfo;
import kr.ac.jejunu.model.response.EventDayJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Service
public class TodayService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${eventDayApi.TDCProjectKey}")
    private String TDCProjectKey;

    @Value("${eventDayApi.url}")
    private String url;

    private String lastUpdatedDate;
    private String today;
    private WeekdayHoliday lastDay;

    public TodayService() {
        lastUpdatedDate = "00000000";
        lastDay = WeekdayHoliday.holiday;
        setToday();
    }

    public WeekdayHoliday whatDayToday() {
        // if last updated date equals today, will not check again.
        if (!isToday()) {
            lastUpdatedDate = today;

            if (isTodayHoliday() || isTodayWeekend())
                lastDay = WeekdayHoliday.holiday;
            else
                lastDay = WeekdayHoliday.weekday;
        }

        return lastDay;
    }

    private boolean isTodayHoliday() {
        try {
            String year = today.substring(0, 4);
            String month = today.substring(4, 6);
            String day = today.substring(6);

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

            ObjectMapper objectMapper = new ObjectMapper();
            EventDayJson eventDayJson = objectMapper.readValue(response, EventDayJson.class);

            ArrayList<EventDayInfo> results = eventDayJson.getResults();

            if (results != null) {
                for (EventDayInfo result : results) {
                    if (result.getType().contains("h") || result.getType().contains("i")) {
                        lastDay = WeekdayHoliday.holiday;
                        return true;
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean isTodayWeekend() {
        Calendar cal = Calendar.getInstance();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Date todayDate = dateFormat.parse(today);
            cal.setTime(todayDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int weekNum = cal.get(Calendar.DAY_OF_WEEK);

        if (weekNum == 1 || weekNum == 7)
            return true;
        else
            return false;

    }

    private boolean isToday() {
        setToday();

        return lastUpdatedDate.equals(today);
    }

    private void setToday() {
        Date todayDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        today = dateFormat.format(todayDate);
    }
}
