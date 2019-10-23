/**
 * 
 */
package com.example.democrud.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.example.democrud.model.Persona;

/**
 * @author mcubilla
 *
 */
public interface PersonaDaoAPI extends CrudRepository<Persona, Long> {

}
