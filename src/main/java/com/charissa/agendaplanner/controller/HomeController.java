package com.charissa.agendaplanner.controller;

import com.charissa.agendaplanner.model.Meeting;
//import com.charissa.agendaplanner.repository.MeetingRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @RequestMapping("/home")
    public String sayHi() {
        return "Hi";
    }
//    private final MeetingRepository repository;
//
//    public HomeController(MeetingController repository) {
//        this.repository = (MeetingRepository) repository;
//    }
//
//    @GetMapping("/all")
//    public Iterable<Meeting> findAll() {
//        return repository.findAll();
//    }

}