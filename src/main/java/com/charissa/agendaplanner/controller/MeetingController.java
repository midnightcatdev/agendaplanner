package com.charissa.agendaplanner.controller;

import com.charissa.agendaplanner.model.Meeting;
import com.charissa.agendaplanner.service.AgendaService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MeetingController {

//    @RequestMapping("/meetingss")
//    public List<Meeting> findAll() {
//        return agendaService.findAll();
//    }
    private final AgendaService agendaService;

    public MeetingController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @QueryMapping
    public List<Meeting> findAll() {
        return agendaService.findAll();
    }

    @QueryMapping
    public Optional<Meeting> findOne(@Argument Integer id) {
        return agendaService.findOne(id);
    }

    @MutationMapping
    public Meeting create(@Argument String title, @Argument String date) {
//        if (date == date) {
//            System.out.println("Niet beschikbaar selecteer een andere dag");
//        }
        return agendaService.create(title, date);
    }

    @MutationMapping
    public Meeting update(@Argument Integer id, @Argument String title, @Argument String date) {
        return agendaService.update(id, title, date);
    }

    @MutationMapping
    public Meeting delete(@Argument Integer id) {
        return agendaService.delete(id);
    }
}
