package com.example.app.controller.rest;

import com.example.app.entity.Province;
import com.example.app.entity.Municipality;
import com.example.app.entity.Country;
import com.example.app.entity.GenericData;
import com.example.app.service.ReferenceDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reference")
@Tag(name = "Reference Data", description = "Reference data API")
public class ReferenceDataRestController {

    private final ReferenceDataService referenceDataService;

    public ReferenceDataRestController(ReferenceDataService referenceDataService) {
        this.referenceDataService = referenceDataService;
    }

    @GetMapping("/provinces")
    @Operation(summary = "Get all provinces")
    public ResponseEntity<List<Province>> getAllProvinces() {
        return ResponseEntity.ok(referenceDataService.getAllProvinces());
    }

    @GetMapping("/provinces/{code}")
    @Operation(summary = "Get province by code")
    public ResponseEntity<Province> getProvinceByCode(@PathVariable String code) {
        return referenceDataService.getProvinceByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/municipalities")
    @Operation(summary = "Get municipalities by province")
    public ResponseEntity<List<Municipality>> getMunicipalitiesByProvince(
            @RequestParam String provinceCode) {
        return ResponseEntity.ok(referenceDataService.getMunicipalitiesByProvince(provinceCode));
    }

    @GetMapping("/countries")
    @Operation(summary = "Get all countries")
    public ResponseEntity<List<Country>> getAllCountries() {
        return ResponseEntity.ok(referenceDataService.getAllCountries());
    }

    @GetMapping("/asset-natures")
    @Operation(summary = "Get asset natures")
    public ResponseEntity<List<GenericData>> getAssetNatures() {
        return ResponseEntity.ok(referenceDataService.getAssetNatures());
    }

    @GetMapping("/asset-positions")
    @Operation(summary = "Get asset positions")
    public ResponseEntity<List<GenericData>> getAssetPositions() {
        return ResponseEntity.ok(referenceDataService.getAssetPositions());
    }
}