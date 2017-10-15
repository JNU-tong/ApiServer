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
public enum WeekdayHoliday {
    weekday, holiday, everyday;

//    public static WeekdayHoliday whatDayToday() throws IOException, ParserConfigurationException, SAXException { // Great method naming....
//
//
//        return null;
//    }
}
