package tn.esprit.springboot.service;

import java.util.List;

import tn.esprit.springboot.entity.Rayon;;

public interface RayonService {

	
	List<Rayon> retrieveAllRayons();

	Rayon addRayon(Rayon r);

	void deleteRayon(Long id);

	Rayon updateRayon(Rayon r);

	Rayon retrieveRayon(Long id);
	
}
