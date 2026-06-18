package com.example.app.repository;

import com.example.app.entity.AssetLegacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AssetLegacyRepository extends JpaRepository<AssetLegacy, Long> {

    List<AssetLegacy> findByPresentationYearAndTaxTypeAndPresentationCodeAndAssetSequence(
            String presentationYear, String taxType, String presentationCode, String assetSequence);

    @Query("SELECT COALESCE(SUM(a.legacyPercentage), 0) FROM AssetLegacy a " +
            "WHERE a.presentationYear = :year AND a.taxType = :taxType " +
            "AND a.presentationCode = :code AND a.assetSequence = :seq " +
            "AND (:excludeId IS NULL OR a.id <> :excludeId)")
    BigDecimal sumLegacyPercentageForAsset(@Param("year") String presentationYear,
                                            @Param("taxType") String taxType,
                                            @Param("code") String presentationCode,
                                            @Param("seq") String assetSequence,
                                            @Param("excludeId") Long excludeId);

    void deleteByPresentationYearAndTaxTypeAndPresentationCodeAndAssetSequence(
            String presentationYear, String taxType, String presentationCode, String assetSequence);
}