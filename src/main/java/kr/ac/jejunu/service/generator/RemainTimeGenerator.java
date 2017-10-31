package kr.ac.jejunu.service.generator;


import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RemainTimeGenerator {
    public static Integer getRemainTime(Date date) {
        Integer remainTime = null;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date current = new Date();
            current = dateFormat.parse(dateFormat.format(current));
            Long departureTime = date.getTime();
            Long currentTIme = current.getTime();
            remainTime = (int) ((departureTime - currentTIme) / 60000);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Date Parsing Error!!");
        }

        return remainTime;
    }
}
