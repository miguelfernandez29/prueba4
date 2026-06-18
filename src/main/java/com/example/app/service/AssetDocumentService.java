package com.example.app.service;

import com.example.app.dto.AssetDocumentDTO;
import com.example.app.entity.AssetDocument;
import com.example.app.entity.AssetDocumentId;
import com.example.app.entity.GenericData;
import com.example.app.repository.AssetDocumentRepository;
import com.example.app.repository.GenericDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AssetDocumentService {

    private static final BigDecimal MAX_VALUE = new BigDecimal("999999999999.99");
    private static final String ASSET_NATURE_DATA_TYPE = "110";
    private static final String ASSET_POSITION_DATA_TYPE = "104";

    private final AssetDocumentRepository assetDocumentRepository;
    private final GenericDataRepository genericDataRepository;

    public AssetDocumentService(AssetDocumentRepository assetDocumentRepository,
                                 GenericDataRepository genericDataRepository) {
        this.assetDocumentRepository = assetDocumentRepository;
        this.genericDataRepository = genericDataRepository;
    }

    public List<AssetDocumentDTO> findByDeclaration(String presentationYear, String taxType, String presentationCode) {
        List<AssetDocument> assets = assetDocumentRepository.findByPresentationYearAndTaxTypeAndPresentationCode(
                presentationYear, taxType, presentationCode);
        return assets.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<AssetDocumentDTO> findById(String presentationYear, String taxType,
                                                String presentationCode, String assetSequence) {
        AssetDocumentId id = new AssetDocumentId(presentationYear, taxType, presentationCode, assetSequence);
        return assetDocumentRepository.findById(id).map(this::toDTO);
    }

    public AssetDocumentDTO create(AssetDocumentDTO dto) {
        validateAssetNature(dto.getAssetNature());
        validateAssetPosition(dto.getAssetPosition());
        validateTransmissionPercentage(dto.getTransmissionPercentage());
        validateMonetaryValue(dto.getDeclaredValue(), "Declared value");
        validateMonetaryValue(dto.getVerifiedValue(), "Verified value");

        String sequence = generateNextSequence(dto.getPresentationYear(), dto.getTaxType(), dto.getPresentationCode());
        dto.setAssetSequence(sequence);

        Long count = assetDocumentRepository.countByKey(dto.getPresentationYear(), dto.getTaxType(),
                dto.getPresentationCode(), sequence);
        if (count > 0) {
            throw new IllegalStateException("Asset already exists. Use modify instead.");
        }

        if (dto.getTransmissionPercentage() == null) {
            dto.setTransmissionPercentage(new BigDecimal("100.00"));
        }

        AssetDocument entity = toEntity(dto);
        entity = assetDocumentRepository.save(entity);
        return toDTO(entity);
    }

    public AssetDocumentDTO update(AssetDocumentDTO dto) {
        AssetDocumentId id = new AssetDocumentId(dto.getPresentationYear(), dto.getTaxType(),
                dto.getPresentationCode(), dto.getAssetSequence());

        AssetDocument existing = assetDocumentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Asset not found"));

        validateTransmissionPercentage(dto.getTransmissionPercentage());
        validateMonetaryValue(dto.getDeclaredValue(), "Declared value");
        validateMonetaryValue(dto.getVerifiedValue(), "Verified value");

        existing.setAssetNature(dto.getAssetNature());
        existing.setAssetPosition(dto.getAssetPosition());
        existing.setTransmissionPercentage(dto.getTransmissionPercentage());
        existing.setDeclaredValue(dto.getDeclaredValue());
        existing.setVerifiedValue(dto.getVerifiedValue());
        existing.setConformityIndicator(dto.getConformityIndicator());
        existing.setReferenceValueSituation(dto.getReferenceValueSituation());
        existing.setHasReferenceValue(dto.getHasReferenceValue());
        existing.setReferenceValue(dto.getReferenceValue());
        existing.setAssetType(dto.getAssetType());
        existing.setObservations(dto.getObservations());

        existing = assetDocumentRepository.save(existing);
        return toDTO(existing);
    }

    public void delete(String presentationYear, String taxType, String presentationCode, String assetSequence) {
        AssetDocumentId id = new AssetDocumentId(presentationYear, taxType, presentationCode, assetSequence);
        if (!assetDocumentRepository.existsById(id)) {
            throw new IllegalArgumentException("Asset not found");
        }
        assetDocumentRepository.deleteById(id);
    }

    public boolean isAssetVerified(String presentationYear, String taxType,
                                    String presentationCode, String assetSequence) {
        return assetDocumentRepository.findVerifiedAsset(presentationYear, taxType, presentationCode, assetSequence)
                .isPresent();
    }

    public BigDecimal calculateProportionalValue(BigDecimal verifiedValue, BigDecimal transmissionPercentage, int decimals) {
        if (verifiedValue == null || transmissionPercentage == null) {
            return null;
        }
        return verifiedValue.multiply(transmissionPercentage)
                .divide(new BigDecimal("100"), decimals, RoundingMode.HALF_UP);
    }

    public String calculateConformity(String hasReferenceValue, String isReferenceValid, BigDecimal referenceValue,
                                       BigDecimal declaredValue) {
        if ("S".equals(hasReferenceValue) && "S".equals(isReferenceValid) && referenceValue != null) {
            if (declaredValue != null && declaredValue.compareTo(referenceValue) >= 0) {
                return "S";
            }
        }
        return "N";
    }

    private String generateNextSequence(String presentationYear, String taxType, String presentationCode) {
        Integer maxSeq = assetDocumentRepository.findMaxAssetSequence(presentationYear, taxType, presentationCode);
        int nextSeq = (maxSeq == null ? 0 : maxSeq) + 1;
        return String.format("%03d", nextSeq);
    }

    private void validateAssetNature(String assetNature) {
        if (assetNature == null || assetNature.trim().isEmpty()) {
            throw new IllegalArgumentException("Asset nature is required");
        }
        Optional<GenericData> data = genericDataRepository.findByDataTypeAndDataCode(ASSET_NATURE_DATA_TYPE, assetNature);
        if (!data.isPresent()) {
            throw new IllegalArgumentException("Invalid asset nature code: " + assetNature);
        }
    }

    private void validateAssetPosition(String assetPosition) {
        if (assetPosition == null || assetPosition.trim().isEmpty()) {
            throw new IllegalArgumentException("Asset position is required");
        }
        Optional<GenericData> data = genericDataRepository.findByDataTypeAndDataCode(ASSET_POSITION_DATA_TYPE, assetPosition);
        if (!data.isPresent()) {
            throw new IllegalArgumentException("Invalid asset position code. Allowed values: P or G");
        }
    }

    private void validateTransmissionPercentage(BigDecimal percentage) {
        if (percentage != null) {
            if (percentage.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Transmission percentage must be greater than 0%");
            }
            if (percentage.compareTo(new BigDecimal("100")) > 0) {
                throw new IllegalArgumentException("Transmission percentage cannot exceed 100%");
            }
        }
    }

    private void validateMonetaryValue(BigDecimal value, String fieldName) {
        if (value != null) {
            if (value.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException(fieldName + " cannot be negative");
            }
            if (value.compareTo(MAX_VALUE) > 0) {
                throw new IllegalArgumentException(fieldName + " exceeds maximum allowed value: 999,999,999,999.99");
            }
        }
    }

    private AssetDocumentDTO toDTO(AssetDocument entity) {
        AssetDocumentDTO dto = new AssetDocumentDTO();
        dto.setPresentationYear(entity.getPresentationYear());
        dto.setTaxType(entity.getTaxType());
        dto.setPresentationCode(entity.getPresentationCode());
        dto.setAssetSequence(entity.getAssetSequence());
        dto.setAssetNature(entity.getAssetNature());
        dto.setAssetPosition(entity.getAssetPosition());
        dto.setTransmissionPercentage(entity.getTransmissionPercentage());
        dto.setDeclaredValue(entity.getDeclaredValue());
        dto.setVerifiedValue(entity.getVerifiedValue());
        dto.setConformityIndicator(entity.getConformityIndicator());
        dto.setReferenceValueSituation(entity.getReferenceValueSituation());
        dto.setHasReferenceValue(entity.getHasReferenceValue());
        dto.setReferenceValue(entity.getReferenceValue());
        dto.setVerificationDate(entity.getVerificationDate());
        dto.setVerificationId(entity.getVerificationId());
        dto.setBusinessAssetSequence(entity.getBusinessAssetSequence());
        dto.setAssetType(entity.getAssetType());
        dto.setObservations(entity.getObservations());

        if (entity.getAssetNature() != null) {
            genericDataRepository.findByDataTypeAndDataCode(ASSET_NATURE_DATA_TYPE, entity.getAssetNature())
                    .ifPresent(data -> dto.setAssetNatureDescription(data.getAbbreviation()));
        }

        if (entity.getVerifiedValue() != null && entity.getTransmissionPercentage() != null) {
            dto.setProportionalVerifiedValue(calculateProportionalValue(
                    entity.getVerifiedValue(), entity.getTransmissionPercentage(), 2));
        }

        return dto;
    }

    private AssetDocument toEntity(AssetDocumentDTO dto) {
        AssetDocument entity = new AssetDocument();
        entity.setPresentationYear(dto.getPresentationYear());
        entity.setTaxType(dto.getTaxType());
        entity.setPresentationCode(dto.getPresentationCode());
        entity.setAssetSequence(dto.getAssetSequence());
        entity.setAssetNature(dto.getAssetNature());
        entity.setAssetPosition(dto.getAssetPosition());
        entity.setTransmissionPercentage(dto.getTransmissionPercentage());
        entity.setDeclaredValue(dto.getDeclaredValue());
        entity.setVerifiedValue(dto.getVerifiedValue());
        entity.setConformityIndicator(dto.getConformityIndicator());
        entity.setReferenceValueSituation(dto.getReferenceValueSituation());
        entity.setHasReferenceValue(dto.getHasReferenceValue());
        entity.setReferenceValue(dto.getReferenceValue());
        entity.setVerificationDate(dto.getVerificationDate());
        entity.setVerificationId(dto.getVerificationId());
        entity.setBusinessAssetSequence(dto.getBusinessAssetSequence());
        entity.setAssetType(dto.getAssetType());
        entity.setObservations(dto.getObservations());
        return entity;
    }
}