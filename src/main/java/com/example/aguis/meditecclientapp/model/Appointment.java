package com.example.aguis.meditecclientapp.model;

/**
 * Created by aguis on 7/5/2017.
 */

public class Appointment {

    private long id;
    private String author;
    private String date;
    private String patientName;

    public Appointment() {

    }

    public Appointment(long id, String patientName, String author, String date) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.patientName = patientName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
