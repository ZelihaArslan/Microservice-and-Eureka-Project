package edu.microservice.isciService.dto;

public class IsciDto {
    private Long id;
    private String isciAdi;
    private String isciSoyadi;
    private String isciMail;
    private String bolumNo;

    public IsciDto() {
    }

    public IsciDto(Long id, String isciAdi, String isciSoyadi, String isciMail, String bolumNo) {
        this.id = id;
        this.isciAdi = isciAdi;
        this.isciSoyadi = isciSoyadi;
        this.isciMail = isciMail;
        this.bolumNo = bolumNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsciAdi() {
        return isciAdi;
    }

    public void setIsciAdi(String isciAdi) {
        this.isciAdi = isciAdi;
    }

    public String getIsciSoyadi() {
        return isciSoyadi;
    }

    public void setIsciSoyadi(String isciSoyadi) {
        this.isciSoyadi = isciSoyadi;
    }

    public String getIsciMail() {
        return isciMail;
    }

    public void setIsciMail(String isciMail) {
        this.isciMail = isciMail;
    }

    public String getBolumNo() {
        return bolumNo;
    }

    public void setBolumNo(String bolumNo) {
        this.bolumNo = bolumNo;
    }
}
