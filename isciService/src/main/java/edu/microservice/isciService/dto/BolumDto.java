package edu.microservice.isciService.dto;

public class BolumDto {
    private Long id;
    private String bolumAdi;
    private String bolumNo;

    public BolumDto() {
    }

    public BolumDto(Long id, String bolumAdi, String bolumNo) {
        this.id = id;
        this.bolumAdi = bolumAdi;
        this.bolumNo = bolumNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBolumAdi() {
        return bolumAdi;
    }

    public void setBolumAdi(String bolumAdi) {
        this.bolumAdi = bolumAdi;
    }

    public String getBolumNo() {
        return bolumNo;
    }

    public void setBolumNo(String bolumNo) {
        this.bolumNo = bolumNo;
    }
}
