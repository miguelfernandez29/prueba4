package com.example.app.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "GATA_BIENURBA")
@IdClass(AssetDocumentId.class)
public class UrbanAsset {

    @Id
    @Column(name = "AAPRESENTA", length = 4)
    private String presentationYear;

    @Id
    @Column(name = "VFTIPOIMPU", length = 2)
    private String taxType;

    @Id
    @Column(name = "CDPRESENTA", length = 14)
    private String presentationCode;

    @Id
    @Column(name = "CDSECUBIEN", length = 3)
    private String assetSequence;

    @Column(name = "CDPROVINCI", length = 2)
    private String provinceCode;

    @Column(name = "CDMUNICIPI", length = 3)
    private String municipalityCode;

    @Column(name = "CDTIPOVIAP", length = 2)
    private String streetType;

    @Column(name = "TLNOMBVIAP", length = 100)
    private String streetName;

    @Column(name = "TLNUMEVIAP", length = 10)
    private String streetNumber;

    @Column(name = "TLCODIPOST", length = 5)
    private String postalCode;

    @Column(name = "TLESCALERA", length = 10)
    private String staircase;

    @Column(name = "TLPISO", length = 10)
    private String floor;

    @Column(name = "TLPUERTA", length = 10)
    private String door;

    @Column(name = "CDPAIS", length = 3)
    private String countryCode;

    @Column(name = "VFDUPLICAD", length = 1)
    private String duplicateFlag;

    @Column(name = "TLNUMELOCA", length = 20)
    private String locationNumber;

    @Column(name = "TLREFECATA", length = 20)
    private String cadastralReference;

    @Column(name = "CDTIPOBIEN", length = 2)
    private String propertyType;

    @Column(name = "ITVIVIHABI", length = 1)
    private String habitualResidence;

    @Column(name = "PTVIVIHABI", precision = 15, scale = 2)
    private BigDecimal habitualResidenceValue;

    @Column(name = "NMUNIDADES")
    private Integer numberOfUnits;

    @Column(name = "NMSUPERFIC", precision = 12, scale = 2)
    private BigDecimal surfaceArea;

    @Column(name = "AACONSTRUC")
    private Integer constructionYear;

    @Column(name = "CDSITUACI1", length = 3)
    private String situationCode1;

    @Column(name = "CDSITUACI2", length = 2)
    private String situationCode2;

    @Column(name = "ITARRENDAM", length = 1)
    private String isRented;

    @Column(name = "AACONTARRE")
    private Integer rentalContractYear;

    @Column(name = "ITPROTOFIC", length = 1)
    private String officialProtection;

    @Column(name = "ITDESCALIF", length = 1)
    private String disqualified;

    @Column(name = "PTMAXVENTA", precision = 15, scale = 2)
    private BigDecimal maximumSalePrice;

    @Column(name = "PCTRANSMIS", precision = 5, scale = 2)
    private BigDecimal transmissionPercentage;

    @Column(name = "PTDECLARAD", precision = 15, scale = 2)
    private BigDecimal declaredValue;

    @Column(name = "PTCOMPROBA", precision = 15, scale = 2)
    private BigDecimal verifiedValue;

    @Column(name = "ITVALORREF", length = 1)
    private String hasReferenceValue;

    @Column(name = "PTVALORREF", precision = 15, scale = 2)
    private BigDecimal referenceValue;

    @Column(name = "TLOBSERVAC", length = 500)
    private String observations;

    @Column(name = "CDPOSBIEN2", length = 1)
    private String assetPosition;

    public UrbanAsset() {
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

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getMunicipalityCode() {
        return municipalityCode;
    }

    public void setMunicipalityCode(String municipalityCode) {
        this.municipalityCode = municipalityCode;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStaircase() {
        return staircase;
    }

    public void setStaircase(String staircase) {
        this.staircase = staircase;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDuplicateFlag() {
        return duplicateFlag;
    }

    public void setDuplicateFlag(String duplicateFlag) {
        this.duplicateFlag = duplicateFlag;
    }

    public String getLocationNumber() {
        return locationNumber;
    }

    public void setLocationNumber(String locationNumber) {
        this.locationNumber = locationNumber;
    }

    public String getCadastralReference() {
        return cadastralReference;
    }

    public void setCadastralReference(String cadastralReference) {
        this.cadastralReference = cadastralReference;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getHabitualResidence() {
        return habitualResidence;
    }

    public void setHabitualResidence(String habitualResidence) {
        this.habitualResidence = habitualResidence;
    }

    public BigDecimal getHabitualResidenceValue() {
        return habitualResidenceValue;
    }

    public void setHabitualResidenceValue(BigDecimal habitualResidenceValue) {
        this.habitualResidenceValue = habitualResidenceValue;
    }

    public Integer getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(Integer numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public BigDecimal getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(BigDecimal surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Integer getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(Integer constructionYear) {
        this.constructionYear = constructionYear;
    }

    public String getSituationCode1() {
        return situationCode1;
    }

    public void setSituationCode1(String situationCode1) {
        this.situationCode1 = situationCode1;
    }

    public String getSituationCode2() {
        return situationCode2;
    }

    public void setSituationCode2(String situationCode2) {
        this.situationCode2 = situationCode2;
    }

    public String getIsRented() {
        return isRented;
    }

    public void setIsRented(String isRented) {
        this.isRented = isRented;
    }

    public Integer getRentalContractYear() {
        return rentalContractYear;
    }

    public void setRentalContractYear(Integer rentalContractYear) {
        this.rentalContractYear = rentalContractYear;
    }

    public String getOfficialProtection() {
        return officialProtection;
    }

    public void setOfficialProtection(String officialProtection) {
        this.officialProtection = officialProtection;
    }

    public String getDisqualified() {
        return disqualified;
    }

    public void setDisqualified(String disqualified) {
        this.disqualified = disqualified;
    }

    public BigDecimal getMaximumSalePrice() {
        return maximumSalePrice;
    }

    public void setMaximumSalePrice(BigDecimal maximumSalePrice) {
        this.maximumSalePrice = maximumSalePrice;
    }

    public BigDecimal getTransmissionPercentage() {
        return transmissionPercentage;
    }

    public void setTransmissionPercentage(BigDecimal transmissionPercentage) {
        this.transmissionPercentage = transmissionPercentage;
    }

    public BigDecimal getDeclaredValue() {
        return declaredValue;
    }

    public void setDeclaredValue(BigDecimal declaredValue) {
        this.declaredValue = declaredValue;
    }

    public BigDecimal getVerifiedValue() {
        return verifiedValue;
    }

    public void setVerifiedValue(BigDecimal verifiedValue) {
        this.verifiedValue = verifiedValue;
    }

    public String getHasReferenceValue() {
        return hasReferenceValue;
    }

    public void setHasReferenceValue(String hasReferenceValue) {
        this.hasReferenceValue = hasReferenceValue;
    }

    public BigDecimal getReferenceValue() {
        return referenceValue;
    }

    public void setReferenceValue(BigDecimal referenceValue) {
        this.referenceValue = referenceValue;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getAssetPosition() {
        return assetPosition;
    }

    public void setAssetPosition(String assetPosition) {
        this.assetPosition = assetPosition;
    }
}