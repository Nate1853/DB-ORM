package de.hska.iwii.db1.jpa;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
public class Buchung {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Min(1)
    @Column(name = "anzahl")
    private Integer anzahl;

    @Column(name = "buchungs_datum", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date buchungsDatum;

    @ManyToOne
    @JoinColumn(name = "kunde_id")
    private Kunde kunde;
    @ManyToOne
    @JoinColumn(name = "flug_id")
    private Flug flug;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(Integer anzahl) {
        this.anzahl = anzahl;
    }

    public Date getBuchungsDatum() {
        return buchungsDatum;
    }

    public void setBuchungsDatum(Date buchungsDatum) {
        this.buchungsDatum = buchungsDatum;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Flug getFlug() {
        return flug;
    }

    public void setFlug(Flug flug) {
        this.flug = flug;
    }

    public Buchung(Long id, Integer anzahl, Date buchungsDatum, Kunde kunde, Flug flug) {
        this.id = id;
        this.anzahl = anzahl;
        this.buchungsDatum = buchungsDatum;
        this.kunde = kunde;
        this.flug = flug;
    }

    public Buchung() {

    }
}
