package edu.microservice.bolumService.repository;

import edu.microservice.bolumService.data.Bolum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BolumRepository extends JpaRepository<Bolum,Long> {
    Bolum findByBolumNo(String bolumNo);
}
