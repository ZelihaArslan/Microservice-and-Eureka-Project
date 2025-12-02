package edu.microservice.isciService.service;

import edu.microservice.isciService.data.Isci;
import edu.microservice.isciService.dto.APIResponseDTOObject;
import edu.microservice.isciService.dto.BolumDto;
import edu.microservice.isciService.dto.IsciDto;
import edu.microservice.isciService.repository.IsciRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class IsciServiceImpl implements IsciServiceInterface{
   private IsciRepository isciRepository;
   //private WebClient webClient;
    private APIClient apiClient;

    public IsciServiceImpl(IsciRepository isciRepository, APIClient apiClient) {
        this.isciRepository = isciRepository;
        this.apiClient = apiClient;
    }

    @Override
    public IsciDto saveIsciDto(IsciDto isciDto) {
        if (isciDto.getBolumNo() == null) {
            throw new IllegalArgumentException("Cannot save Isci without a bolumNo.");
        }
        Isci isci=new Isci(isciDto.getId(), isciDto.getIsciAdi(), isciDto.getIsciSoyadi(), isciDto.getIsciMail(),isciDto.getBolumNo());
        Isci saveIsci=isciRepository.save(isci);
        IsciDto saveIsciDto=new IsciDto(saveIsci.getId(), saveIsci.getIsciAdi(), saveIsci.getIsciSoyadi(), saveIsci.getIsciMail(), saveIsci.getBolumNo());
        return saveIsciDto;
    }

    @Override
    public APIResponseDTOObject getirIsciWithId(Long isciId) {
        Isci isci = isciRepository.findById(isciId).orElseThrow(() -> new RuntimeException("Isci not found with id: " + isciId));

        if (isci.getBolumNo() == null) {
            throw new RuntimeException("Isci with id: " + isciId + " has no Bolum assigned (bolumNo is null).");
        }

        BolumDto bolumDto= apiClient.getirBolum(Long.valueOf(isci.getBolumNo()));
        if (bolumDto == null) {
            throw new RuntimeException("Bolum not found for isci id: " + isciId);
        }
        IsciDto isciDto=new IsciDto(isci.getId(), isci.getIsciAdi(), isci.getIsciSoyadi(), isci.getIsciMail(), isci.getBolumNo());
        APIResponseDTOObject apiResponseDTOObject=new APIResponseDTOObject();
        apiResponseDTOObject.setIsciDTOApi(isciDto);
        apiResponseDTOObject.setBolumDTOApi(bolumDto);
        return apiResponseDTOObject;
    }
}
