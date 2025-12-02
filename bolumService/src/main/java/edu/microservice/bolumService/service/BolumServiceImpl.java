package edu.microservice.bolumService.service;

import edu.microservice.bolumService.data.Bolum;
import edu.microservice.bolumService.dto.BolumDto;
import edu.microservice.bolumService.repository.BolumRepository;
import org.springframework.stereotype.Service;

@Service
public class BolumServiceImpl implements BolumServiceInterface {

    BolumRepository bolumRepository;
    public BolumServiceImpl(BolumRepository bolumRepository) {
        this.bolumRepository = bolumRepository;
    }

    @Override
    public BolumDto kaydetBolumDto(BolumDto bolumDto) {
        Bolum bolum=new Bolum(bolumDto.getId(), bolumDto.getBolumAdi(), bolumDto.getBolumNo());
        Bolum savebolum=bolumRepository.save(bolum);
        BolumDto saveBolumDto=new BolumDto(savebolum.getId(), savebolum.getBolumAdi(), savebolum.getBolumNo());
        return saveBolumDto;
    }

    @Override
    public BolumDto getirBolumWithCode(Long bolumId) {
        Bolum bolum = bolumRepository.findById(bolumId)
                .orElseThrow(() -> new RuntimeException("Bolum not found with id: " + bolumId));
        BolumDto bolumDto=new BolumDto(bolum.getId(), bolum.getBolumAdi(), bolum.getBolumNo());
        return bolumDto;
    }
}
