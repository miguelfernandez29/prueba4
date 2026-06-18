package com.example.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "SUCA_PAIS")
public class Country {

    @Id
    @Column(name = "CDPAIS", length = 3)
    private String code;

    @Column(name = "DSPAIS", length = 100)
    private String name;

    public Country() {
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