package de.hska.iwii.db1.jpa;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.*;


public class JPAApplication {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager em;




	public JPAApplication(){
		Logger.getLogger("org.hibernate").setLevel(Level.ALL);
		entityManagerFactory = Persistence.createEntityManagerFactory("DB1");

		testFlights();
		readBookings("Hazard");

		entityManagerFactory.close();
	}


	public void testFlights() {
		em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		Kunde Niklas = new Kunde(1L,"Niklas", "Mustermann", "niklas@email.com");
		Kunde Hazard = new Kunde(2L,"Nathan", "Hazard", "hazard@email.com");

		Flug munichHK = new Flug(1L, 6001, Time.valueOf("15:30:00"), "Muenchen");
		Flug HKmunich = new Flug(2L, 6002, Time.valueOf("16:30:00"), "HK");
		Flug KAmunich = new Flug(3L, 6003, Time.valueOf("17:30:00"), "Berlin");


		Buchung buchung1 = new Buchung(1L,1, new Date(), Niklas, munichHK);
		Buchung buchung2 = new Buchung(2L,1, new Date(), Hazard, KAmunich);
		Buchung buchung3 = new Buchung(3L,1, new Date(), Niklas, KAmunich);
		Buchung buchung4 = new Buchung(4L,1, new Date(), Hazard, HKmunich);

		Niklas.getKundenid().add(buchung1);
		Niklas.getKundenid().add(buchung3);
		Hazard.getKundenid().add(buchung2);
		Hazard.getKundenid().add(buchung4);

		munichHK.getBuchung().add(buchung1);
		KAmunich.getBuchung().add(buchung2);
		KAmunich.getBuchung().add(buchung3);
		HKmunich.getBuchung().add(buchung4);


		em.persist(Niklas);
		em.persist(Hazard);
		em.persist(munichHK);
		em.persist(HKmunich);
		em.persist(KAmunich);
		em.persist(buchung1);
		em.persist(buchung2);
		em.persist(buchung3);
		em.persist(buchung4);
		em.getTransaction().commit();
		em.close();
	}


	public void readBookings(String Nachname) {
		em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("FROM Kunde",Kunde.class);

		List<Kunde> kunden = em.createQuery("FROM Kunde WHERE nachName = :nachName",
				Kunde.class).setParameter("nachName", Nachname).getResultList();
		for (Kunde tmp: kunden) {
				for (Buchung tmp2: tmp.getKundenid()) {
						System.out.println("Flug: " + tmp2.getFlug().getNummer()
						+ "\nNachname: " + tmp2.getKunde().getNachName());
			}

		}
		em.getTransaction().commit();
		em.close();
	}

	public static void main(String[] args){
		new JPAApplication();
	}
}
