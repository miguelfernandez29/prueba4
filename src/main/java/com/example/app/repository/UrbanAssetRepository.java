package com.example.app.repository;

import com.example.app.entity.UrbanAsset;
import com.example.app.entity.AssetDocumentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrbanAssetRepository extends JpaRepository<UrbanAsset, AssetDocumentId> {

    List<UrbanAsset> findByPresentationYearAndTaxTypeAndPresentationCode(
            String presentationYear, String taxType, String presentationCode);
}