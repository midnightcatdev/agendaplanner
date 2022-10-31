package com.charissa.agendaplanner.model;

import org.springframework.data.annotation.Id;

public record Meeting(@Id Integer id, String title, String date) {
}
