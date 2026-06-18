package com.example.app.controller.rest;

import com.example.app.dto.AssetLegacyDTO;
import com.example.app.service.AssetLegacyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/legacies")
@Tag(name = "Asset Legacies", description = "Asset legacy assignment management API")
public class AssetLegacyRestController {

    private final AssetLegacyService assetLegacyService;

    public AssetLegacyRestController(AssetLegacyService assetLegacyService) {
        this.assetLegacyService = assetLegacyService;
    }

    @GetMapping
    @Operation(summary = "Get legacies by asset")
    public ResponseEntity<List<AssetLegacyDTO>> getLegaciesByAsset(
            @RequestParam String presentationYear,
            @RequestParam String taxType,
            @RequestParam String presentationCode,
            @RequestParam String assetSequence) {
        List<AssetLegacyDTO> legacies = assetLegacyService.findByAsset(
                presentationYear, taxType, presentationCode, assetSequence);
        return ResponseEntity.ok(legacies);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get legacy by ID")
    public ResponseEntity<AssetLegacyDTO> getLegacyById(@PathVariable Long id) {
        return assetLegacyService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create new legacy assignment")
    public ResponseEntity<AssetLegacyDTO> createLegacy(@Valid @RequestBody AssetLegacyDTO dto) {
        AssetLegacyDTO created = assetLegacyService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update legacy assignment")
    public ResponseEntity<AssetLegacyDTO> updateLegacy(
            @PathVariable Long id,
            @Valid @RequestBody AssetLegacyDTO dto) {
        dto.setId(id);
        AssetLegacyDTO updated = assetLegacyService.update(dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete legacy assignment")
    public ResponseEntity<Void> deleteLegacy(@PathVariable Long id) {
        assetLegacyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}