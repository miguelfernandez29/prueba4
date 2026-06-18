package com.example.app.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class BankAccountDTO {

    @NotBlank(message = "Presentation year is required")
    private String presentationYear;

    @NotBlank(message = "Tax type is required")
    private String taxType;

    @NotBlank(message = "Presentation code is required")
    private String presentationCode;

    private String assetSequence;

    @NotBlank(message = "Financial institution is required")
    private String financialInstitution;

    @NotBlank(message = "Account number is required")
    private String accountNumber;

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
    private String observations;
    private String assetPosition;
    private String assetNature;
    private String assetNatureDescription;

    public BankAccountDTO() {
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

    public String getFinancialInstitution() {
        return financialInstitution;
    }

    public void setFinancialInstitution(String financialInstitution) {
        this.financialInstitution = financialInstitution;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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