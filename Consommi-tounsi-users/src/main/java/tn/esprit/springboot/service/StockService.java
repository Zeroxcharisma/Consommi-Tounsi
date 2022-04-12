package tn.esprit.springboot.service;

import java.util.List;

import tn.esprit.springboot.entity.Stock;

public interface StockService {
	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	Stock updateStock(Stock u);

	Stock retrieveStock(Long id);
	
	void deleteStock(Long id);

}
