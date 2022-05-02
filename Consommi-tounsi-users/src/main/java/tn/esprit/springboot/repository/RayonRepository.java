package tn.esprit.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.springboot.entity.Rayon;

@Repository
public interface RayonRepository extends CrudRepository<Rayon, Long> {

}
