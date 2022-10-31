package com.charissa.agendaplanner.service;

import com.charissa.agendaplanner.model.Agenda;
import com.charissa.agendaplanner.model.Meeting;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AgendaRegistrationService {
    private static final List<Agenda> agendas = new ArrayList<>();
    AtomicInteger id = new AtomicInteger(0);

    public static List<Agenda> findAll() { return agendas; }

    public Optional<Agenda> findOne(Integer id) {
        return agendas.stream().filter(agenda -> agenda.id() == id).findFirst();
    }

    public Agenda create(String date, String meeting) {
        Agenda agenda = new Agenda(id.incrementAndGet(), date, meeting);
        agendas.add(agenda);
        return agenda;
    }

    public Agenda update(Integer id, String date, String meeting) {
        Agenda updatedAgenda = new Agenda(id, date, meeting);
        Optional<Agenda> optional = agendas.stream().filter(a -> a.id() == id).findFirst();
        if (optional.isPresent()) {
            Agenda agenda = optional.get();
            int index = agendas.indexOf(agenda);
            agendas.set(index, updatedAgenda);
        } else {
            throw new IllegalArgumentException("Invalid meeting");
        }
        return updatedAgenda;
    }

    public Agenda delete(Integer id) {
        Agenda agenda = agendas.stream().filter(a -> a.id() == id).findFirst().orElseThrow(() -> new IllegalArgumentException());
        agendas.remove(agenda);
        return agenda;
    }

    @PostConstruct
    private void init() {
        agendas.add(new Agenda(id.incrementAndGet(), "Meeting with John Doe", ""));
        agendas.add(new Agenda(id.incrementAndGet(), "Meeting with John Doe", "12-30-1222"));
        agendas.add(new Agenda(id.incrementAndGet(), "Meeting with John Doe", ""));

    }

}

