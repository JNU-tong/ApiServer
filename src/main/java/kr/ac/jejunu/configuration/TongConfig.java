package kr.ac.jejunu.configuration;

import kr.ac.jejunu.configuration.interceptor.JsonInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Collections;

@Configuration
public class TongConfig {
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new JsonInterceptor()));
        return restTemplate;
    }

    @Bean
    public SimpleDateFormat simpleDateFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        return dateFormat;
    }
}