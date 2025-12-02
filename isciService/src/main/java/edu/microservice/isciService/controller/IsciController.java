package edu.microservice.isciService.controller;

import edu.microservice.isciService.dto.APIResponseDTOObject;
import edu.microservice.isciService.dto.IsciDto;
import edu.microservice.isciService.service.IsciServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("uygulama/isciler")
public class IsciController {
     IsciServiceInterface isciServiceInterface;

    public IsciController(IsciServiceInterface isciServiceInterface) {
        this.isciServiceInterface = isciServiceInterface;
    }
    @PostMapping
    public ResponseEntity<IsciDto> saveIsci(@RequestBody IsciDto isciDto) {
        IsciDto saveIsciDto = isciServiceInterface.saveIsciDto(isciDto);
        return new ResponseEntity<>(saveIsciDto, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDTOObject> getirIsci(@PathVariable("id") Long isciId) {
    APIResponseDTOObject getir=isciServiceInterface.getirIsciWithId(isciId);
    return new ResponseEntity<>(getir, HttpStatus.OK);
    }
}

