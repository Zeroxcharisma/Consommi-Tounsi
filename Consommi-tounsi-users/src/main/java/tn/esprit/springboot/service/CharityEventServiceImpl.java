package tn.esprit.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.springboot.entity.CharityEvent;
import tn.esprit.springboot.entity.Reservation;
import tn.esprit.springboot.entity.User;
import tn.esprit.springboot.repository.ICharityEventRepository;

import tn.esprit.springboot.repository.IReservationRepository;
import tn.esprit.springboot.repository.UserRepository;

@Service
public class CharityEventServiceImpl  implements ICharityEventService {

	@Autowired
	ICharityEventRepository eR;
	@Autowired
	UserRepository Ur;
	@Autowired
	IReservationRepository RR;
	
	
	@Override
	public CharityEvent addEvent(CharityEvent e) {
		return eR.save(e);
	}
	
	@Override
	public int getNombrePlacesEvent(int idevent){
		return eR.NombrePlacesEvent(idevent);		
	}
	@Override
	public int getNombreParticpEvent(int idevent){
		return eR.NombreParticpEvent(idevent);
	}
	public List<Integer> getEventList(){
		return eR.CharityEventList();
	}

	@Override
	public void deleteEvent(int id) {
		eR.deleteById(id);
		
	}

	@Override
	public void FaireReservation(int idReservation ,int idUser,int idEvent) {
		
		CharityEvent e=eR.findById(idEvent).get();
        User user=Ur.findById(idUser).get();
		Reservation r=RR.findById(idReservation).get();
		
		r.setUser(user);
		r.setCharityEvent(e);
		RR.save(r);
	}

	

	@Override
	public List<CharityEvent>retreiveAllEvent(){
		
		List<CharityEvent> e = (List <CharityEvent>)eR.findAll();
		return e;
	}

	@Override
	public CharityEvent updateEvent(CharityEvent e) {
		return eR.save(e);
	}

	@Override
	public void addReservation(Reservation r) {
		
		RR.save(r);
	}
	
	
	
	
}