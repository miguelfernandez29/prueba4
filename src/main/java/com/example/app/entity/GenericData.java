package com.example.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "GATA_DATOGENA")
public class GenericData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CDTIPODATO", length = 3)
    private String dataType;

    @Column(name = "CDDATOGENA", length = 2)
    private String dataCode;

    @Column(name = "DSABREV", length = 100)
    private String abbreviation;

    @Column(name = "DSDATOGENA", length = 200)
    private String description;

    public GenericData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}