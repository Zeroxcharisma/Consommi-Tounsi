package tn.esprit.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.springboot.entity.Reservation;


@Repository
public interface IReservationRepository extends CrudRepository<Reservation,Integer>{

}