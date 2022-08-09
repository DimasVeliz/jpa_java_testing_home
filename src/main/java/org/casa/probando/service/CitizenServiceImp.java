package org.casa.probando.service;

import java.util.List;
import java.util.Optional;

import org.casa.probando.dao.CitizenDao;
import org.casa.probando.models.citizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenServiceImp  implements CitizenService{
    
    CitizenDao CitizenRepository;

    @Autowired
    public CitizenServiceImp(CitizenDao repository) {
        super();
        this.CitizenRepository=repository;
    }

    @Override
	public List<citizen> GetAll()
    {
        return CitizenRepository.findAll();
    }


	@Override
	public citizen findById(int theId) {
		Optional<citizen> result = CitizenRepository.findById(theId);
		
		citizen theCitizen = null;
		
		if (result.isPresent()) {
			theCitizen = result.get();
		}
		else {
			// we didn't find the Citizen
			throw new RuntimeException("Did not find Citizen id - " + theId);
		}
		
		return theCitizen;
	}

	@Override
	public void save(citizen theCitizen) {
		CitizenRepository.save(theCitizen);
	}

	@Override
	public void deleteById(int theId) {
		CitizenRepository.deleteById(theId);
	}
}
