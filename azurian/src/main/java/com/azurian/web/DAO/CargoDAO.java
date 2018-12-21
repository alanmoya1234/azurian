package com.azurian.web.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CargoDAO {
	
	@Autowired
	private ICargoDAO crud;
	
	public ICargoDAO crud() {
		return this.crud;
	}
}
