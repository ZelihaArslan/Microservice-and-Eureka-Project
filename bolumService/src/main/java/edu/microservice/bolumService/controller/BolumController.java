package edu.microservice.bolumService.controller;

import edu.microservice.bolumService.dto.BolumDto;
import edu.microservice.bolumService.service.BolumServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("uygulama/bolumler")
public class BolumController {
    private BolumServiceInterface bolumServiceInterface;

    public BolumController(BolumServiceInterface bolumServiceInterface) {
        this.bolumServiceInterface = bolumServiceInterface;
    }

    @PostMapping
    public ResponseEntity<BolumDto> saveBolum(@RequestBody BolumDto bolumDto) {
        BolumDto saveBolumDto = bolumServiceInterface.kaydetBolumDto(bolumDto);
        return new ResponseEntity<>(saveBolumDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<BolumDto> getBolum(@PathVariable("id") Long bolumId) {
        BolumDto getir = bolumServiceInterface.getirBolumWithCode(bolumId);
        return new ResponseEntity<>(getir, HttpStatus.OK);
    }
}
