package com.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "votes")
public class Vote {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "global_seq"
    )
    @SequenceGenerator(
            name = "global_seq",
            allocationSize = 1
    )
    private int id;
    /*    @JsonSerialize(converter = LocalDateToStringConverter.class)
        @JsonDeserialize(converter = StringToLocalDateConverter.class)*/
    @Column(name = "date")
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy")
    @NotNull
    private LocalDate date;

    /*    @JsonSerialize(converter = LocalTimeToStringConverter.class)
        @JsonDeserialize(converter = StringToLocalTimeConverter.class)*/
    @Column(name = "time")
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "hh:mm:ss")
    @NotNull
    private LocalTime time;

    @Column(name = "rest_id")
    @NotNull
    private int rest_id;

    @Column(name = "username")
    @NotBlank
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getRest_id() {
        return rest_id;
    }

    public void setRest_id(int rest_id) {
        this.rest_id = rest_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

/*
class LocalDateToStringConverter extends StdConverter<LocalDate, String> {
    static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);

    @Override
    public String convert(LocalDate value) {
        return value.format(DATE_FORMATTER);
    }
}

class StringToLocalDateConverter extends StdConverter<String, LocalDate> {

    @Override
    public LocalDate convert(String value) {
        return LocalDate.parse(value, LocalDateToStringConverter.DATE_FORMATTER);
    }
}



class LocalTimeToStringConverter extends StdConverter<LocalTime, String> {
    static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);

    @Override
    public String convert(LocalTime value) {
        return value.format(DATE_FORMATTER);
    }
}

class StringToLocalTimeConverter extends StdConverter<String, LocalTime> {

    @Override
    public LocalTime convert(String value) {
        return LocalTime.parse(value, LocalDateToStringConverter.DATE_FORMATTER);
    }
}*/
