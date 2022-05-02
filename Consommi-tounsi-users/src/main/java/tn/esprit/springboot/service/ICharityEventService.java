package tn.esprit.springboot.service;

import java.util.List;

import tn.esprit.springboot.entity.CharityEvent;
import tn.esprit.springboot.entity.Reservation;

public interface ICharityEventService {
	
void deleteEvent(int id);
	
	CharityEvent addEvent(CharityEvent e);
	
	public void FaireReservation(int idReservation ,int idUser,int idEvent);
	
	int getNombrePlacesEvent(int idevent);

	int getNombreParticpEvent(int idevent);
	
	List<CharityEvent>retreiveAllEvent();
	
	public List<Integer> getEventList();
	
	CharityEvent updateEvent(CharityEvent e);
	
	void addReservation(Reservation r);

}
