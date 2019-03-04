package com.example.demo.controller;

import com.example.demo.model.DTO.ToursDTO;
import com.example.demo.model.domain.Tours;
import com.example.demo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//контроллер для туров
@RestController
@RequestMapping("tours")
public class ToursController {

    private final AppService appService;

    @Autowired
    public ToursController(AppService appService) {
        this.appService = appService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<ToursDTO> Tours() {
        return appService.getAllTours();
    }

    @RequestMapping(value = "{tourId}", method = RequestMethod.GET)
    public ToursDTO getOneTour(@PathVariable("tourId") Long tourId) {
        return appService.getOneTour(tourId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ToursDTO addTour(@RequestBody ToursDTO tour) {
        return appService.saveTour(tour);
    }

    @RequestMapping(value = "{tourId}", method = RequestMethod.PUT)
    public ToursDTO updateTour(@RequestBody ToursDTO tours) {
        return appService.saveTour(tours);
    }

    @RequestMapping(value = "{tourId}", method = RequestMethod.DELETE)
    public void removeTour(@PathVariable("tortId") Long tourId) {
        appService.removeTour(tourId);
    }
}
