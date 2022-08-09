package org.casa.probando.dao;

import org.casa.probando.models.citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenDao extends JpaRepository<citizen, Integer> {

    
}
