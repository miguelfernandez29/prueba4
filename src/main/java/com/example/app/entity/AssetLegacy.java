package com.example.app.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "GATA_BIENLEGA")
public class AssetLegacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AAPRESENTA", length = 4)
    private String presentationYear;

    @Column(name = "VFTIPOIMPU", length = 2)
    private String taxType;

    @Column(name = "CDPRESENTA", length = 14)
    private String presentationCode;

    @Column(name = "CDSECUBIEN", length = 3)
    private String assetSequence;

    @Column(name = "CDNIFCAUSA", length = 9)
    private String deceasedNif;

    @Column(name = "CDSUBCAUSA", length = 2)
    private String deceasedSubCode;

    @Column(name = "CDNIFSUPAS", length = 9)
    private String beneficiaryNif;

    @Column(name = "CDSUBSUPAS", length = 2)
    private String beneficiarySubCode;

    @Column(name = "ITLEGADO", length = 1)
    private String isLegacy;

    @Column(name = "PCLEGADOSP", precision = 5, scale = 2)
    private BigDecimal legacyPercentage;

    @Column(name = "CDTPADQUI2", length = 1)
    private String acquisitionType;

    public AssetLegacy() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPresentationYear() {
        return presentationYear;
    }

    public void setPresentationYear(String presentationYear) {
        this.presentationYear = presentationYear;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getPresentationCode() {
        return presentationCode;
    }

    public void setPresentationCode(String presentationCode) {
        this.presentationCode = presentationCode;
    }

    public String getAssetSequence() {
        return assetSequence;
    }

    public void setAssetSequence(String assetSequence) {
        this.assetSequence = assetSequence;
    }

    public String getDeceasedNif() {
        return deceasedNif;
    }

    public void setDeceasedNif(String deceasedNif) {
        this.deceasedNif = deceasedNif;
    }

    public String getDeceasedSubCode() {
        return deceasedSubCode;
    }

    public void setDeceasedSubCode(String deceasedSubCode) {
        this.deceasedSubCode = deceasedSubCode;
    }

    public String getBeneficiaryNif() {
        return beneficiaryNif;
    }

    public void setBeneficiaryNif(String beneficiaryNif) {
        this.beneficiaryNif = beneficiaryNif;
    }

    public String getBeneficiarySubCode() {
        return beneficiarySubCode;
    }

    public void setBeneficiarySubCode(String beneficiarySubCode) {
        this.beneficiarySubCode = beneficiarySubCode;
    }

    public String getIsLegacy() {
        return isLegacy;
    }

    public void setIsLegacy(String isLegacy) {
        this.isLegacy = isLegacy;
    }

    public BigDecimal getLegacyPercentage() {
        return legacyPercentage;
    }

    public void setLegacyPercentage(BigDecimal legacyPercentage) {
        this.legacyPercentage = legacyPercentage;
    }

    public String getAcquisitionType() {
        return acquisitionType;
    }

    public void setAcquisitionType(String acquisitionType) {
        this.acquisitionType = acquisitionType;
    }
}