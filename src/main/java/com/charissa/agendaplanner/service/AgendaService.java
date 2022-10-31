package com.charissa.agendaplanner.service;

import com.charissa.agendaplanner.model.Meeting;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AgendaService {
    private List<Meeting> meetings = new ArrayList<>();
    AtomicInteger id = new AtomicInteger(0);

    public List<Meeting> findAll() {
        return meetings;
    }

    public Optional<Meeting> findOne(Integer id) {
        return meetings.stream().filter(meeting -> meeting.id() == id).findFirst();
    }

    public Meeting create(String title, String date) {
        Meeting meeting = new Meeting(id.incrementAndGet(), title, date);
        meetings.add(meeting);
        return meeting;
    }

    public Meeting update(Integer id, String title, String date) {
        Meeting updatedMeeting = new Meeting(id, title, date);
        Optional<Meeting> optional = meetings.stream().filter(m -> m.id() == id).findFirst();
        if (optional.isPresent()) {
            Meeting meeting = optional.get();
            int index = meetings.indexOf(meeting);
            meetings.set(index, updatedMeeting);
        } else {
            throw new IllegalArgumentException("Invalid meeting");
        }
        return updatedMeeting;
    }

    public Meeting delete(Integer id) {
        Meeting meeting = meetings.stream().filter(m -> m.id() == id).findFirst().orElseThrow(() -> new IllegalArgumentException());
        meetings.remove(meeting);
        return meeting;
    }

    @PostConstruct
    private void init() {
        meetings.add(new Meeting(id.incrementAndGet(), "Meeting with John Doe","29/12/2022"));
        meetings.add(new Meeting(id.incrementAndGet(), "Meeting with Topicus","31/10/2022"));
        meetings.add(new Meeting(id.incrementAndGet(), "Meeting with Jane Doe","12/7/2022"));
        meetings.add(new Meeting(id.incrementAndGet(), "Christmas with the family","03/7/2022"));
        meetings.add(new Meeting(id.incrementAndGet(), "New years eve","01/7/2022"));
        meetings.add(new Meeting(id.incrementAndGet(), "Getting a new huskey dog","09/7/2022"));
    }

}

