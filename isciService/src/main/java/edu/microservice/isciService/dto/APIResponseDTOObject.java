package edu.microservice.isciService.dto;

public class APIResponseDTOObject {
    private IsciDto isciDTOApi;
    private BolumDto bolumDTOApi;

    public APIResponseDTOObject(IsciDto isciDTOApi, BolumDto bolumDTOApi) {
        this.isciDTOApi = isciDTOApi;
        this.bolumDTOApi = bolumDTOApi;
    }

    public APIResponseDTOObject() {
    }

    public IsciDto getIsciDTOApi() {
        return isciDTOApi;
    }

    public void setIsciDTOApi(IsciDto isciDTOApi) {
        this.isciDTOApi = isciDTOApi;
    }

    public BolumDto getBolumDTOApi() {
        return bolumDTOApi;
    }

    public void setBolumDTOApi(BolumDto bolumDTOApi) {
        this.bolumDTOApi = bolumDTOApi;
    }
}
