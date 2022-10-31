package com.charissa.agendaplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import com.charissa.agendaplanner.repository.MeetingRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class AgendaplannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgendaplannerApplication.class, args);
        getDate();
//        geefEersteVrijeSlotVanaf();
//        notAvailable();
    }

    public static void getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = formatter.parse("14/09/1992");
            System.out.println("Date is: " + date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

//    public static void 	geefEersteVrijeSlotVanaf() {
//        System.out.println("Eerst volgende beschikbare dag is" + x);
//    }

//    public static void notAvailable() {
//
//        System.out.println("Not free, please chose another date");
//    }
}

