package com.example.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "SUCA_PROVINCIA")
public class Province {

    @Id
    @Column(name = "CDPROV", length = 2)
    private String code;

    @Column(name = "DSPROV", length = 100)
    private String name;

    public Province() {
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