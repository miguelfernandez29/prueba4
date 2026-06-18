package com.example.app.repository;

import com.example.app.entity.RusticAsset;
import com.example.app.entity.AssetDocumentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RusticAssetRepository extends JpaRepository<RusticAsset, AssetDocumentId> {

    List<RusticAsset> findByPresentationYearAndTaxTypeAndPresentationCode(
            String presentationYear, String taxType, String presentationCode);
}