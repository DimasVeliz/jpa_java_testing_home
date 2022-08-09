package org.casa.probando.controllers;

import java.util.List;

import org.casa.probando.models.citizen;
import org.casa.probando.service.CitizenServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CitizenController {

    CitizenServiceImp service;

    @Autowired
    public CitizenController(CitizenServiceImp service) {
        super();
        this.service=service;
    }

    @GetMapping("/citizens")
    public List<citizen> GetAll()
    {
        var response = service.GetAll();
        return response;
    }

    @GetMapping("/citizens/{citizenId}")
	public citizen getcitizen(@PathVariable int citizenId) {
		
		citizen thecitizen = service.findById(citizenId);
		
		if (thecitizen == null) {
			throw new RuntimeException("citizen id not found - " + citizenId);
		}
		
		return thecitizen;
	}
	
	// add mapping for POST /citizens - add new citizen
	
	@PostMapping("/citizens")
	public citizen addcitizen(@RequestBody citizen thecitizen) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		thecitizen.setId(0);
		
		service.save(thecitizen);
		
		return thecitizen;
	}
	
	// add mapping for PUT /citizens - update existing citizen
	
	@PutMapping("/citizens")
	public citizen updatecitizen(@RequestBody citizen thecitizen) {
		
		service.save(thecitizen);
		
		return thecitizen;
	}
	
	// add mapping for DELETE /citizens/{citizenId} - delete citizen
	
	@DeleteMapping("/citizens/{citizenId}")
	public String deletecitizen(@PathVariable int citizenId) {
		
		citizen tempcitizen = service.findById(citizenId);
		
		// throw exception if null
		
		if (tempcitizen == null) {
			throw new RuntimeException("citizen id not found - " + citizenId);
		}
		
		service.deleteById(citizenId);
		
		return "Deleted citizen id - " + citizenId;
	}
	
}
