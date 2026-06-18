package com.example.app.controller.rest;

import com.example.app.dto.AssetDocumentDTO;
import com.example.app.service.AssetDocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/assets")
@Tag(name = "Asset Documents", description = "Asset document management API")
public class AssetDocumentRestController {

    private final AssetDocumentService assetDocumentService;

    public AssetDocumentRestController(AssetDocumentService assetDocumentService) {
        this.assetDocumentService = assetDocumentService;
    }

    @GetMapping
    @Operation(summary = "Get assets by declaration")
    public ResponseEntity<List<AssetDocumentDTO>> getAssetsByDeclaration(
            @RequestParam String presentationYear,
            @RequestParam String taxType,
            @RequestParam String presentationCode) {
        List<AssetDocumentDTO> assets = assetDocumentService.findByDeclaration(
                presentationYear, taxType, presentationCode);
        return ResponseEntity.ok(assets);
    }

    @GetMapping("/{presentationYear}/{taxType}/{presentationCode}/{assetSequence}")
    @Operation(summary = "Get asset by ID")
    public ResponseEntity<AssetDocumentDTO> getAssetById(
            @PathVariable String presentationYear,
            @PathVariable String taxType,
            @PathVariable String presentationCode,
            @PathVariable String assetSequence) {
        return assetDocumentService.findById(presentationYear, taxType, presentationCode, assetSequence)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create new asset")
    public ResponseEntity<AssetDocumentDTO> createAsset(@Valid @RequestBody AssetDocumentDTO dto) {
        AssetDocumentDTO created = assetDocumentService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{presentationYear}/{taxType}/{presentationCode}/{assetSequence}")
    @Operation(summary = "Update asset")
    public ResponseEntity<AssetDocumentDTO> updateAsset(
            @PathVariable String presentationYear,
            @PathVariable String taxType,
            @PathVariable String presentationCode,
            @PathVariable String assetSequence,
            @Valid @RequestBody AssetDocumentDTO dto) {
        dto.setPresentationYear(presentationYear);
        dto.setTaxType(taxType);
        dto.setPresentationCode(presentationCode);
        dto.setAssetSequence(assetSequence);
        AssetDocumentDTO updated = assetDocumentService.update(dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{presentationYear}/{taxType}/{presentationCode}/{assetSequence}")
    @Operation(summary = "Delete asset")
    public ResponseEntity<Void> deleteAsset(
            @PathVariable String presentationYear,
            @PathVariable String taxType,
            @PathVariable String presentationCode,
            @PathVariable String assetSequence) {
        assetDocumentService.delete(presentationYear, taxType, presentationCode, assetSequence);
        return ResponseEntity.noContent().build();
    }
}