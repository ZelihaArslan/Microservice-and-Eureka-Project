package edu.microservice.isciService.repository;

import edu.microservice.isciService.data.Isci;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IsciRepository extends JpaRepository<Isci, Long> {
}
