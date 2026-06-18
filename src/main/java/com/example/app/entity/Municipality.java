package com.example.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "SUCA_MUNICIPIO")
public class Municipality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CDPROV", length = 2)
    private String provinceCode;

    @Column(name = "CDMUNI", length = 3)
    private String code;

    @Column(name = "DSMUNI", length = 100)
    private String name;

    public Municipality() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}