package com.example.app.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AssetDocumentDTO {

    @NotBlank(message = "Presentation year is required")
    private String presentationYear;

    @NotBlank(message = "Tax type is required")
    private String taxType;

    @NotBlank(message = "Presentation code is required")
    private String presentationCode;

    private String assetSequence;

    @NotBlank(message = "Asset nature is required")
    private String assetNature;

    @NotBlank(message = "Asset position is required")
    private String assetPosition;

    @DecimalMin(value = "0.00", message = "Transmission percentage must be at least 0")
    @DecimalMax(value = "100.00", message = "Transmission percentage cannot exceed 100")
    private BigDecimal transmissionPercentage;

    @DecimalMin(value = "0.00", message = "Declared value must be positive")
    @DecimalMax(value = "999999999999.99", message = "Declared value exceeds maximum")
    private BigDecimal declaredValue;

    @DecimalMin(value = "0.00", message = "Verified value must be positive")
    @DecimalMax(value = "999999999999.99", message = "Verified value exceeds maximum")
    private BigDecimal verifiedValue;

    private String conformityIndicator;
    private String referenceValueSituation;
    private String hasReferenceValue;
    private BigDecimal referenceValue;
    private LocalDate verificationDate;
    private String verificationId;
    private String businessAssetSequence;
    private String assetType;
    private String observations;
    private String assetNatureDescription;
    private BigDecimal proportionalVerifiedValue;
    private String hasReduction;

    public AssetDocumentDTO() {
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

    public String getAssetNature() {
        return assetNature;
    }

    public void setAssetNature(String assetNature) {
        this.assetNature = assetNature;
    }

    public String getAssetPosition() {
        return assetPosition;
    }

    public void setAssetPosition(String assetPosition) {
        this.assetPosition = assetPosition;
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

    public String getConformityIndicator() {
        return conformityIndicator;
    }

    public void setConformityIndicator(String conformityIndicator) {
        this.conformityIndicator = conformityIndicator;
    }

    public String getReferenceValueSituation() {
        return referenceValueSituation;
    }

    public void setReferenceValueSituation(String referenceValueSituation) {
        this.referenceValueSituation = referenceValueSituation;
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

    public LocalDate getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(LocalDate verificationDate) {
        this.verificationDate = verificationDate;
    }

    public String getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(String verificationId) {
        this.verificationId = verificationId;
    }

    public String getBusinessAssetSequence() {
        return businessAssetSequence;
    }

    public void setBusinessAssetSequence(String businessAssetSequence) {
        this.businessAssetSequence = businessAssetSequence;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getAssetNatureDescription() {
        return assetNatureDescription;
    }

    public void setAssetNatureDescription(String assetNatureDescription) {
        this.assetNatureDescription = assetNatureDescription;
    }

    public BigDecimal getProportionalVerifiedValue() {
        return proportionalVerifiedValue;
    }

    public void setProportionalVerifiedValue(BigDecimal proportionalVerifiedValue) {
        this.proportionalVerifiedValue = proportionalVerifiedValue;
    }

    public String getHasReduction() {
        return hasReduction;
    }

    public void setHasReduction(String hasReduction) {
        this.hasReduction = hasReduction;
    }
}