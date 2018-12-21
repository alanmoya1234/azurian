package com.azurian.web.DAO;

import org.springframework.data.repository.CrudRepository;

import com.azurian.web.entity.Cargo;

public interface ICargoDAO extends CrudRepository<Cargo, Integer>{

}
