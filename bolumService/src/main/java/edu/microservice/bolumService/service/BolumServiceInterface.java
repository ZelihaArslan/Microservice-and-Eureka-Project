package edu.microservice.bolumService.service;

import edu.microservice.bolumService.dto.BolumDto;

public interface BolumServiceInterface {
    BolumDto kaydetBolumDto(BolumDto bolumDto);
    BolumDto getirBolumWithCode(Long bolumId);
}
