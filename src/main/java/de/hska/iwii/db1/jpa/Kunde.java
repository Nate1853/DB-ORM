package de.hska.iwii.db1.jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Kunde")
public class Kunde {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "vor_name", nullable = false)
    private String vorName;
    @Column(name = "nach_name", nullable = false)
    private String nachName;
    @Column(name = "email", nullable = false)
    private String email;

    @JoinColumn(name = "kunde_id")
    @OneToMany
    private List<Buchung> kundenid = new ArrayList<>();

    // Getter, Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorName() {
        return vorName;
    }

    public void setVorName(String vorName) {
        this.vorName = vorName;
    }

    public String getNachName() {
        return nachName;
    }

    public void setNachName(String nachName) {
        this.nachName = nachName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Buchung> getKundenid() {
        return kundenid;
    }

    public void setKundenid(List<Buchung> kundenid) {
        this.kundenid = kundenid;
    }

    public Kunde(Long id, String vorName, String nachName, String email) {
        this.id = id;
        this.vorName = vorName;
        this.nachName = nachName;
        this.email = email;
    }

    // default constructor
    public Kunde() {
    }

}
