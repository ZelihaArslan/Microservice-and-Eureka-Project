package edu.microservice.isciService.service;

import edu.microservice.isciService.dto.BolumDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bolumService")
public interface APIClient {
    @GetMapping("/uygulama/bolumler/{id}")
    BolumDto getirBolum(@PathVariable("id") Long bolumId);
}
