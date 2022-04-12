package tn.esprit.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.springboot.entity.Rayon;
import tn.esprit.springboot.repository.RayonRepository;

@Service
public class RayonServiceImpl implements RayonService{

	
	@Autowired
	private RayonRepository rayonRepository;
	
	@Override
	public List<Rayon> retrieveAllRayons() {
		return (List<Rayon>) rayonRepository.findAll();
	}

	@Override
	public Rayon addRayon(Rayon r) {
		
		return rayonRepository.save(r);
		
	}

	@Override
	public void deleteRayon(Long id) {
		rayonRepository.deleteById(id);
		
	}

	@Override
	public Rayon updateRayon(Rayon r) {
		return rayonRepository.save(r);
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		return rayonRepository.findById(id).orElse(null);
	}

}
