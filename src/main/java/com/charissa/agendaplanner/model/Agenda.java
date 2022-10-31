package com.charissa.agendaplanner.model;

import org.springframework.data.annotation.Id;

public record Agenda(@Id Integer id, String date, String meeting) {

}
