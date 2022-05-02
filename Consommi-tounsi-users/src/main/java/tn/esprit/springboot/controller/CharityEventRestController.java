package tn.esprit.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.springboot.entity.CharityEvent;
import tn.esprit.springboot.entity.Reservation;
import tn.esprit.springboot.service.ICharityEventService;




@RestController
@RequestMapping("charity")
public class CharityEventRestController {
	
	
	@Autowired
	ICharityEventService eS;
	
	// http://localhost:8083/springmvc/charity/addEvent
		@PostMapping("/addEvent")
		@ResponseBody
		public CharityEvent addEvent(@RequestBody CharityEvent e) {
			eS.addEvent(e);
		return e;
		}

		
		// http://localhost:8083/springmvc/charity/retrieveallEvent
				@GetMapping("/retrieveallEvent")
				@ResponseBody
				public List<CharityEvent> getEvent() {
				List<CharityEvent> list = eS.retreiveAllEvent();
				return list;
				}
		
				
				
				// http://localhost:8083/springmvc/charity/remove-event/{idDelivery}
				@DeleteMapping("/remove-event/{idEvent}")
				@ResponseBody
				public void removeEvent(@PathVariable("idEvent") int id) {
				eS.deleteEvent(id); 
				}
				
				
		
				
				//http://localhost:8083/springmvc/charity/FaireReservation/{idUser}/{idEvent}
				@PostMapping("/FaireReservation/{idReservation}/{idUser}/{idEvent}")
				public void FaireReservation(@PathVariable(value = "idReservation")int idreservation,@PathVariable(value = "idUser") int idUser,
				@PathVariable(value = "idEvent") int idEvent) {
				eS.FaireReservation( idreservation,idUser, idEvent);
				}
				
				
				//http://localhost:8083/springmvc/charity/addReservation
					@PostMapping("/addReservation")
					@ResponseBody
					public Reservation addReservation(@RequestBody Reservation r) {
						eS.addReservation(r);
					return r;
					}
				
				


}
