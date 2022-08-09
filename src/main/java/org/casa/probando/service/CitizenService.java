package org.casa.probando.service;

import java.util.List;

import org.casa.probando.models.citizen;

public interface CitizenService {
    

	public List<citizen> GetAll();

	
	public citizen findById(int theId);

	
	public void save(citizen theCitizen);

	
	public void deleteById(int theId) ;
}
