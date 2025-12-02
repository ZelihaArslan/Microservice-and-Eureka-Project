package edu.microservice.bolumService.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bolum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bolumAdi;
    private String bolumNo;

    public Bolum() {
    }

    public Bolum(Long id, String bolumAdi, String bolumNo) {
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
