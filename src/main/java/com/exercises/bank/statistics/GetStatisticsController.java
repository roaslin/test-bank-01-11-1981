package com.exercises.bank.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class GetStatisticsController {

    private final GetStatisticsService service;

    @Autowired
    public GetStatisticsController(GetStatisticsService service) {
        this.service = service;
    }

    @GetMapping("statistics")
    public ResponseEntity<Statistics> getStatistics() {
        Statistics statistics = service.getStatistics();

        return new ResponseEntity<>(statistics, OK);
    }
}
