package com.charissa.agendaplanner.controller;

import com.charissa.agendaplanner.model.Agenda;
import com.charissa.agendaplanner.model.Meeting;
import com.charissa.agendaplanner.service.AgendaRegistrationService;
import com.charissa.agendaplanner.service.AgendaService;
import org.springframework.data.annotation.Id;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AgendaController {

    @RequestMapping("/agenda")
    public List<Agenda> findAll() { return AgendaRegistrationService.findAll(); }

    private final AgendaRegistrationService agendaRegistrationService;

    public AgendaController(AgendaRegistrationService agendaRegistrationService) {
        this.agendaRegistrationService = agendaRegistrationService;
    }

//    @QueryMapping
//    public List<Meeting> findAll() {
//        return agendaService.findAll();
//    }

    @QueryMapping
    public Optional<Agenda> findOne(@Argument Integer id) {
        return agendaRegistrationService.findOne(id);
    }

    @MutationMapping
    public Agenda create(@Argument String date, Meeting meeting) {
//        if (date == date) {
//            System.out.println("Niet beschikbaar");
//        }
        return agendaRegistrationService.create(date, String.valueOf(meeting));
    }

    @MutationMapping
    public Agenda update(@Argument Integer id, @Argument String date, String meeting) {
        return agendaRegistrationService.update(id, date, meeting);
    }

    @MutationMapping
    public Agenda delete(@Argument Integer id) {
        return agendaRegistrationService.delete(id);
    }
}

