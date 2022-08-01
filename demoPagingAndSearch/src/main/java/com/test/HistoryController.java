package com.test;

import com.test.model.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/manager-account")
public class HistoryController {
    @Autowired
    private HistoryRepository historyRepository;


    @GetMapping("/view-point-add")
    public Page<History> getAdd(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
                                   @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);

        return historyRepository.findHistoriesByCreateDateBetweenAndPointAddGreaterThan(pageable, beginDate, endDate, 0);
    }

    @GetMapping ("/view-point-change")
    public Page<History> getChange(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
                                   @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);

        return historyRepository.findHistoriesByCreateDateBetweenAndPointChangeGreaterThan(pageable, beginDate, endDate, 0);
    }
}
