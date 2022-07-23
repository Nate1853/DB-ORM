package de.hska.iwii.db1.jpa;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Flug {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nummer", nullable = false)
    private Integer nummer;
    @Column(name = "start_zeit", nullable = false)
    private Time startZeit;
    @Column(name = "start_flughafen", nullable = false)
    private String startFlughafen;

    @JoinColumn(name = "flug_id")
    @OneToMany
    private List<Buchung> buchung = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNummer() {
        return nummer;
    }

    public void setNummer(Integer nummer) {
        this.nummer = nummer;
    }

    public Time getStartZeit() {
        return startZeit;
    }

    public void setStartZeit(Time startZeit) {
        this.startZeit = startZeit;
    }

    public String getStartFlughafen() {
        return startFlughafen;
    }

    public void setStartFlughafen(String startFlughafen) {
        this.startFlughafen = startFlughafen;
    }

    public List<Buchung> getBuchung() {
        return buchung;
    }

    public void setBuchung(List<Buchung> buchung) {
        this.buchung = buchung;
    }

    // default constructor
    public Flug() {
    }

    public Flug(Long id, Integer nummer, Time startZeit, String startFlughafen) {
        this.id = id;
        this.nummer = nummer;
        this.startZeit = startZeit;
        this.startFlughafen = startFlughafen;
    }

    // getter + setter
}
