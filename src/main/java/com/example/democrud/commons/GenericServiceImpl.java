package com.example.democrud.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public abstract class GenericServiceImpl <T , ID extends Serializable> implements GenericServiceAPI<T ,ID> {

	@Override
	public T save(T entity) {		
		return getDao().save(entity);
	}

	@Override
	public void delete(ID id) {
		getDao().deleteById(id);		
	}

	@Override
	public T get(ID id) {		
		
		Optional<T> obj = getDao().findById(id);
		
		if(obj.isPresent()){
			return obj.get();
		}
		
		return null;		
	}

	@Override
	public List<T> getAll() {
		List<T> returnList = new ArrayList<>();
		getDao().findAll().forEach(obj -> returnList.add(obj));
		//se hace esto por que tengo java 5 en la maquina
		/*Iterable<T> allList = getDao().findAll();
		
		for (T elem : allList) {
			returnList.add(elem);
		}*/
				
		return returnList;
	}
	
	public abstract  CrudRepository<T, ID> getDao();

}
