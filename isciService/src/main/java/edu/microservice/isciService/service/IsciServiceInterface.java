package edu.microservice.isciService.service;

import edu.microservice.isciService.dto.APIResponseDTOObject;
import edu.microservice.isciService.dto.IsciDto;

public interface IsciServiceInterface {
    IsciDto saveIsciDto(IsciDto isciDto);
    APIResponseDTOObject getirIsciWithId(Long isciId);
}
