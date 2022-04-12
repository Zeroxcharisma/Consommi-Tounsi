package tn.esprit.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.springboot.entity.Stock;
import tn.esprit.springboot.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	private StockRepository stockRepository;

	@Override
	public List<Stock> retrieveAllStocks() {
		return (List<Stock>) stockRepository.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		return stockRepository.save(s);
	}

	@Override
	public Stock updateStock(Stock s) {
		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(Long id) {
		return stockRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteStock(Long id) {
		
		stockRepository.deleteById(id);
	}

}
