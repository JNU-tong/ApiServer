package kr.ac.jejunu.service;

import kr.ac.jejunu.repository.BusScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusScheduleService {
    @Autowired
    private BusScheduleRepository busScheduleRepository;
}