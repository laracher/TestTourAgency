package com.example.demo.controller;

import com.example.demo.domain.Tours;
import com.example.demo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tours")
public class ToursController {

    private final AppService appService;

    @Autowired
    public ToursController(AppService appService) {
        this.appService = appService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Tours> getAll() {
        return appService.getAllTours();
    }

    @RequestMapping(value = "{tourId}", method = RequestMethod.GET)
    public Tours getOne(@PathVariable("tourId") Long tourId) {
        return appService.getOneTour(tourId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Tours addTour(@RequestBody Tours tour) {
        return appService.saveTour(tour);
    }

    @RequestMapping(value = "{tourId}", method = RequestMethod.PUT)
    public Tours updateTour(@RequestBody Tours tours) {
        return appService.saveTour(tours);
    }

    @RequestMapping(value = "{tourId}", method = RequestMethod.DELETE)
    public void remove(@PathVariable("tortId") Long tourId) {
        appService.removeTour(tourId);
    }
}
