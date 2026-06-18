package com.example.app.service;

import com.example.app.dto.AssetLegacyDTO;
import com.example.app.entity.AssetLegacy;
import com.example.app.repository.AssetLegacyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AssetLegacyService {

    private static final BigDecimal MAX_PERCENTAGE = new BigDecimal("100.00");

    private final AssetLegacyRepository assetLegacyRepository;

    public AssetLegacyService(AssetLegacyRepository assetLegacyRepository) {
        this.assetLegacyRepository = assetLegacyRepository;
    }

    public List<AssetLegacyDTO> findByAsset(String presentationYear, String taxType,
                                             String presentationCode, String assetSequence) {
        List<AssetLegacy> legacies = assetLegacyRepository
                .findByPresentationYearAndTaxTypeAndPresentationCodeAndAssetSequence(
                        presentationYear, taxType, presentationCode, assetSequence);
        return legacies.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<AssetLegacyDTO> findById(Long id) {
        return assetLegacyRepository.findById(id).map(this::toDTO);
    }

    public AssetLegacyDTO create(AssetLegacyDTO dto) {
        validateLegacy(dto);
        validateTotalLegacyPercentage(dto, null);

        if (dto.getBeneficiaryNif() != null) {
            dto.setBeneficiaryNif(String.format("%9s", dto.getBeneficiaryNif()).replace(' ', '0'));
        }

        AssetLegacy entity = toEntity(dto);
        entity = assetLegacyRepository.save(entity);
        return toDTO(entity);
    }

    public AssetLegacyDTO update(AssetLegacyDTO dto) {
        AssetLegacy existing = assetLegacyRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Legacy assignment not found"));

        validateLegacy(dto);
        validateTotalLegacyPercentage(dto, dto.getId());

        updateEntity(existing, dto);
        existing = assetLegacyRepository.save(existing);
        return toDTO(existing);
    }

    public void delete(Long id) {
        if (!assetLegacyRepository.existsById(id)) {
            throw new IllegalArgumentException("Legacy assignment not found");
        }
        assetLegacyRepository.deleteById(id);
    }

    private void validateLegacy(AssetLegacyDTO dto) {
        if (!"S".equals(dto.getIsLegacy()) && !"N".equals(dto.getIsLegacy())) {
            throw new IllegalArgumentException("Is legacy must be S or N");
        }

        if ("S".equals(dto.getIsLegacy())) {
            if (dto.getLegacyPercentage() == null) {
                throw new IllegalArgumentException("Legacy percentage is required when is legacy is S");
            }
            if (dto.getAcquisitionType() == null || dto.getAcquisitionType().trim().isEmpty()) {
                throw new IllegalArgumentException("Acquisition type is required when is legacy is S");
            }
            if (!"P".equals(dto.getAcquisitionType()) && !"N".equals(dto.getAcquisitionType())) {
                throw new IllegalArgumentException("Acquisition type must be P or N");
            }
        }

        if (dto.getLegacyPercentage() != null) {
            if (dto.getLegacyPercentage().compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("Legacy percentage cannot be negative");
            }
            if (dto.getLegacyPercentage().compareTo(MAX_PERCENTAGE) > 0) {
                throw new IllegalArgumentException("Legacy percentage cannot exceed 100%");
            }
        }
    }

    private void validateTotalLegacyPercentage(AssetLegacyDTO dto, Long excludeId) {
        if (dto.getLegacyPercentage() == null) {
            return;
        }

        BigDecimal existingTotal = assetLegacyRepository.sumLegacyPercentageForAsset(
                dto.getPresentationYear(), dto.getTaxType(), dto.getPresentationCode(),
                dto.getAssetSequence(), excludeId);

        BigDecimal newTotal = existingTotal.add(dto.getLegacyPercentage());
        if (newTotal.compareTo(MAX_PERCENTAGE) > 0) {
            throw new IllegalArgumentException("Total legacy percentages for this asset cannot exceed 100%");
        }
    }

    private AssetLegacyDTO toDTO(AssetLegacy entity) {
        AssetLegacyDTO dto = new AssetLegacyDTO();
        dto.setId(entity.getId());
        dto.setPresentationYear(entity.getPresentationYear());
        dto.setTaxType(entity.getTaxType());
        dto.setPresentationCode(entity.getPresentationCode());
        dto.setAssetSequence(entity.getAssetSequence());
        dto.setDeceasedNif(entity.getDeceasedNif());
        dto.setDeceasedSubCode(entity.getDeceasedSubCode());
        dto.setBeneficiaryNif(entity.getBeneficiaryNif());
        dto.setBeneficiarySubCode(entity.getBeneficiarySubCode());
        dto.setIsLegacy(entity.getIsLegacy());
        dto.setLegacyPercentage(entity.getLegacyPercentage());
        dto.setAcquisitionType(entity.getAcquisitionType());
        return dto;
    }

    private AssetLegacy toEntity(AssetLegacyDTO dto) {
        AssetLegacy entity = new AssetLegacy();
        updateEntity(entity, dto);
        return entity;
    }

    private void updateEntity(AssetLegacy entity, AssetLegacyDTO dto) {
        entity.setPresentationYear(dto.getPresentationYear());
        entity.setTaxType(dto.getTaxType());
        entity.setPresentationCode(dto.getPresentationCode());
        entity.setAssetSequence(dto.getAssetSequence());
        entity.setDeceasedNif(dto.getDeceasedNif());
        entity.setDeceasedSubCode(dto.getDeceasedSubCode());
        entity.setBeneficiaryNif(dto.getBeneficiaryNif());
        entity.setBeneficiarySubCode(dto.getBeneficiarySubCode());
        entity.setIsLegacy(dto.getIsLegacy());
        entity.setLegacyPercentage(dto.getLegacyPercentage());
        entity.setAcquisitionType(dto.getAcquisitionType());
    }
}