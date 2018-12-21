package com.azurian.web.DAO;

import org.springframework.data.repository.CrudRepository;

import com.azurian.web.entity.Persona;

public interface IPersonaDAO extends CrudRepository<Persona, Integer> {

}
