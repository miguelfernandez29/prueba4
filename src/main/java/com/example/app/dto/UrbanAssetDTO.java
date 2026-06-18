package com.example.app.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class UrbanAssetDTO {

    @NotBlank(message = "Presentation year is required")
    private String presentationYear;

    @NotBlank(message = "Tax type is required")
    private String taxType;

    @NotBlank(message = "Presentation code is required")
    private String presentationCode;

    private String assetSequence;

    @NotBlank(message = "Province code is required")
    private String provinceCode;

    private String provinceName;

    @NotBlank(message = "Municipality code is required")
    private String municipalityCode;

    private String municipalityName;

    private String streetType;
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String staircase;
    private String floor;
    private String door;
    private String countryCode;
    private String countryName;
    private String duplicateFlag;
    private String locationNumber;

    @Size(max = 20, message = "Cadastral reference cannot exceed 20 characters")
    private String cadastralReference;

    @NotBlank(message = "Property type is required")
    private String propertyType;

    private String propertyTypeDescription;

    @Pattern(regexp = "^[SN]?$", message = "Habitual residence must be S or N")
    private String habitualResidence;

    @DecimalMax(value = "999999999999.99", message = "Habitual residence value exceeds maximum")
    private BigDecimal habitualResidenceValue;

    private Integer numberOfUnits;

    @DecimalMax(value = "9999999999.99", message = "Surface area exceeds maximum")
    private BigDecimal surfaceArea;

    @Min(value = 1500, message = "Construction year must be at least 1500")
    private Integer constructionYear;

    private String situationCode;
    private String situationDescription;

    @Pattern(regexp = "^[SN]?$", message = "Is rented must be S or N")
    private String isRented;

    private Integer rentalContractYear;

    @Pattern(regexp = "^[SN]?$", message = "Official protection must be S or N")
    private String officialProtection;

    @Pattern(regexp = "^[SN]?$", message = "Disqualified must be S or N")
    private String disqualified;

    @DecimalMax(value = "999999999999.99", message = "Maximum sale price exceeds maximum")
    private BigDecimal maximumSalePrice;

    @DecimalMin(value = "0.00", message = "Transmission percentage must be at least 0")
    @DecimalMax(value = "100.00", message = "Transmission percentage cannot exceed 100")
    private BigDecimal transmissionPercentage;

    @NotNull(message = "Declared value is required")
    @DecimalMin(value = "0.00", message = "Declared value must be positive")
    @DecimalMax(value = "999999999999.99", message = "Declared value exceeds maximum")
    private BigDecimal declaredValue;

    @DecimalMax(value = "999999999999.99", message = "Verified value exceeds maximum")
    private BigDecimal verifiedValue;

    private BigDecimal proportionalVerifiedValue;
    private String hasReferenceValue;
    private BigDecimal referenceValue;
    private String observations;
    private String assetPosition;
    private String assetNature;
    private String assetNatureDescription;

    public UrbanAssetDTO() {
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

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getMunicipalityCode() {
        return municipalityCode;
    }

    public void setMunicipalityCode(String municipalityCode) {
        this.municipalityCode = municipalityCode;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
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

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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

    public String getPropertyTypeDescription() {
        return propertyTypeDescription;
    }

    public void setPropertyTypeDescription(String propertyTypeDescription) {
        this.propertyTypeDescription = propertyTypeDescription;
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

    public String getSituationCode() {
        return situationCode;
    }

    public void setSituationCode(String situationCode) {
        this.situationCode = situationCode;
    }

    public String getSituationDescription() {
        return situationDescription;
    }

    public void setSituationDescription(String situationDescription) {
        this.situationDescription = situationDescription;
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

    public BigDecimal getProportionalVerifiedValue() {
        return proportionalVerifiedValue;
    }

    public void setProportionalVerifiedValue(BigDecimal proportionalVerifiedValue) {
        this.proportionalVerifiedValue = proportionalVerifiedValue;
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

    public String getAssetNature() {
        return assetNature;
    }

    public void setAssetNature(String assetNature) {
        this.assetNature = assetNature;
    }

    public String getAssetNatureDescription() {
        return assetNatureDescription;
    }

    public void setAssetNatureDescription(String assetNatureDescription) {
        this.assetNatureDescription = assetNatureDescription;
    }
}