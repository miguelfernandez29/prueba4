package com.example.app.controller.rest;

import com.example.app.dto.UrbanAssetDTO;
import com.example.app.service.UrbanAssetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/urban-assets")
@Tag(name = "Urban Assets", description = "Urban property asset management API")
public class UrbanAssetRestController {

    private final UrbanAssetService urbanAssetService;

    public UrbanAssetRestController(UrbanAssetService urbanAssetService) {
        this.urbanAssetService = urbanAssetService;
    }

    @GetMapping
    @Operation(summary = "Get urban assets by declaration")
    public ResponseEntity<List<UrbanAssetDTO>> getUrbanAssetsByDeclaration(
            @RequestParam String presentationYear,
            @RequestParam String taxType,
            @RequestParam String presentationCode) {
        List<UrbanAssetDTO> assets = urbanAssetService.findByDeclaration(
                presentationYear, taxType, presentationCode);
        return ResponseEntity.ok(assets);
    }

    @GetMapping("/{presentationYear}/{taxType}/{presentationCode}/{assetSequence}")
    @Operation(summary = "Get urban asset by ID")
    public ResponseEntity<UrbanAssetDTO> getUrbanAssetById(
            @PathVariable String presentationYear,
            @PathVariable String taxType,
            @PathVariable String presentationCode,
            @PathVariable String assetSequence) {
        return urbanAssetService.findById(presentationYear, taxType, presentationCode, assetSequence)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create new urban asset")
    public ResponseEntity<UrbanAssetDTO> createUrbanAsset(@Valid @RequestBody UrbanAssetDTO dto) {
        UrbanAssetDTO created = urbanAssetService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{presentationYear}/{taxType}/{presentationCode}/{assetSequence}")
    @Operation(summary = "Update urban asset")
    public ResponseEntity<UrbanAssetDTO> updateUrbanAsset(
            @PathVariable String presentationYear,
            @PathVariable String taxType,
            @PathVariable String presentationCode,
            @PathVariable String assetSequence,
            @Valid @RequestBody UrbanAssetDTO dto) {
        dto.setPresentationYear(presentationYear);
        dto.setTaxType(taxType);
        dto.setPresentationCode(presentationCode);
        dto.setAssetSequence(assetSequence);
        UrbanAssetDTO updated = urbanAssetService.update(dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{presentationYear}/{taxType}/{presentationCode}/{assetSequence}")
    @Operation(summary = "Delete urban asset")
    public ResponseEntity<Void> deleteUrbanAsset(
            @PathVariable String presentationYear,
            @PathVariable String taxType,
            @PathVariable String presentationCode,
            @PathVariable String assetSequence) {
        urbanAssetService.delete(presentationYear, taxType, presentationCode, assetSequence);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/apply-conformity")
    @Operation(summary = "Apply conformity to urban asset")
    public ResponseEntity<UrbanAssetDTO> applyConformity(@Valid @RequestBody UrbanAssetDTO dto) {
        UrbanAssetDTO result = urbanAssetService.applyConformity(dto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/apply-reference-value")
    @Operation(summary = "Apply reference value to urban asset")
    public ResponseEntity<UrbanAssetDTO> applyReferenceValue(@Valid @RequestBody UrbanAssetDTO dto) {
        UrbanAssetDTO result = urbanAssetService.applyReferenceValue(dto);
        return ResponseEntity.ok(result);
    }
}