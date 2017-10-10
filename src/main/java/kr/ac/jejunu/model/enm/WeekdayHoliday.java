package kr.ac.jejunu.model.enm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Boobby on 17-9-18.
 */
@ConfigurationPropertiesBinding
public enum WeekdayHoliday {
    weekday, holiday, everyday;

    @Value("${eventDayApi.TDCProjectKey}")
    private static String TDCProjectKey;

    @Value("${eventDayApi.url}")
    private static String url;

    private static String LAST_DATE = "00000000";
    private static WeekdayHoliday LAST_DAY  = WeekdayHoliday.weekday;

    public static WeekdayHoliday whatDayToday() throws IOException, ParserConfigurationException, SAXException { // Great method naming....
        Date today = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        String fullDate = dateFormat.format(today);

        if (!LAST_DATE.equals(fullDate)) {
            LAST_DATE = fullDate;

            String year = fullDate.substring(0, 4);
            String month = fullDate.substring(4, 6);
            String day = fullDate.substring(6);

            URI requestUrl = UriComponentsBuilder.newInstance()
                    .scheme("http")
                    .host(url)
                    .queryParam("TDCProjectKey", URLDecoder.decode(TDCProjectKey, "UTF-8"))
                    .queryParam("type", "")
                    .queryParam("year", year)
                    .queryParam("month", month)
                    .queryParam("day", day)
                    .build()
                    .toUri();

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(requestUrl.toString());

            document.getDocumentElement().normalize();

            System.out.println(document.toString());
        }

        return null;
    }
}
