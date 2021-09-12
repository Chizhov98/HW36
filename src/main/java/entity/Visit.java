package entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class Visit {
    private final String name;
    private final String date;
    private final String city;

    public Visit(String name, String date, String city) {
        this.name = name;
        this.date = date;
        this.city = city;
    }

    public Visit(Visit visit) {
        this.name = visit.getName();
        this.date = visit.getDate();
        this.city = visit.getCity();
    }
}
