package com.example.app.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "GATA_BIENRUST")
@IdClass(AssetDocumentId.class)
public class RusticAsset {

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

    @Column(name = "TLREFECATA", length = 20)
    private String cadastralReference;

    @Column(name = "TLCODIPOST", length = 5)
    private String postalCode;

    @Column(name = "CDPAIS", length = 3)
    private String countryCode;

    @Column(name = "TLPARAJE", length = 100)
    private String locationPlace;

    @Column(name = "TLPOLIGONO", length = 10)
    private String polygon;

    @Column(name = "TLPARCELA", length = 10)
    private String plot;

    @Column(name = "CDTIPOBIEN", length = 2)
    private String propertyType;

    @Column(name = "CDUNIMEDI1", length = 3)
    private String measurementUnitCode1;

    @Column(name = "CDUNIMEDI2", length = 2)
    private String measurementUnitCode2;

    @Column(name = "NMSUPERFIC", precision = 14, scale = 4)
    private BigDecimal surfaceArea;

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

    public RusticAsset() {
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

    public String getCadastralReference() {
        return cadastralReference;
    }

    public void setCadastralReference(String cadastralReference) {
        this.cadastralReference = cadastralReference;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLocationPlace() {
        return locationPlace;
    }

    public void setLocationPlace(String locationPlace) {
        this.locationPlace = locationPlace;
    }

    public String getPolygon() {
        return polygon;
    }

    public void setPolygon(String polygon) {
        this.polygon = polygon;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getMeasurementUnitCode1() {
        return measurementUnitCode1;
    }

    public void setMeasurementUnitCode1(String measurementUnitCode1) {
        this.measurementUnitCode1 = measurementUnitCode1;
    }

    public String getMeasurementUnitCode2() {
        return measurementUnitCode2;
    }

    public void setMeasurementUnitCode2(String measurementUnitCode2) {
        this.measurementUnitCode2 = measurementUnitCode2;
    }

    public BigDecimal getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(BigDecimal surfaceArea) {
        this.surfaceArea = surfaceArea;
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