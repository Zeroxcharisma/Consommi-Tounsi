package tn.esprit.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.springboot.entity.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long>{

}
