package kr.ac.jejunu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Boobby on 17-9-16.
 */
@SpringBootApplication
public class TongApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(TongApplication.class, args);
    }
}
