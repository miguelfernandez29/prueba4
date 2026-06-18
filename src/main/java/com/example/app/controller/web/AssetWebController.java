package com.example.app.controller.web;

import com.example.app.dto.AssetDocumentDTO;
import com.example.app.service.AssetDocumentService;
import com.example.app.service.ReferenceDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/assets")
public class AssetWebController {

    private final AssetDocumentService assetDocumentService;
    private final ReferenceDataService referenceDataService;

    public AssetWebController(AssetDocumentService assetDocumentService,
                               ReferenceDataService referenceDataService) {
        this.assetDocumentService = assetDocumentService;
        this.referenceDataService = referenceDataService;
    }

    @GetMapping
    public String listAssets(@RequestParam(required = false) String presentationYear,
                              @RequestParam(required = false) String taxType,
                              @RequestParam(required = false) String presentationCode,
                              Model model) {
        if (presentationYear != null && taxType != null && presentationCode != null) {
            List<AssetDocumentDTO> assets = assetDocumentService.findByDeclaration(
                    presentationYear, taxType, presentationCode);
            model.addAttribute("assets", assets);
        }
        model.addAttribute("presentationYear", presentationYear);
        model.addAttribute("taxType", taxType);
        model.addAttribute("presentationCode", presentationCode);
        model.addAttribute("title", "Asset Verification List");
        return "assets/list";
    }

    @GetMapping("/new")
    public String newAssetForm(@RequestParam String presentationYear,
                                @RequestParam String taxType,
                                @RequestParam String presentationCode,
                                Model model) {
        AssetDocumentDTO dto = new AssetDocumentDTO();
        dto.setPresentationYear(presentationYear);
        dto.setTaxType(taxType);
        dto.setPresentationCode(presentationCode);
        model.addAttribute("asset", dto);
        model.addAttribute("assetNatures", referenceDataService.getAssetNatures());
        model.addAttribute("assetPositions", referenceDataService.getAssetPositions());
        model.addAttribute("title", "New Asset");
        model.addAttribute("action", "create");
        return "assets/form";
    }

    @PostMapping("/create")
    public String createAsset(@Valid @ModelAttribute("asset") AssetDocumentDTO dto,
                               BindingResult result,
                               Model model,
                               RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("assetNatures", referenceDataService.getAssetNatures());
            model.addAttribute("assetPositions", referenceDataService.getAssetPositions());
            model.addAttribute("title", "New Asset");
            model.addAttribute("action", "create");
            return "assets/form";
        }

        try {
            assetDocumentService.create(dto);
            redirectAttributes.addFlashAttribute("successMessage", "Asset created successfully");
            return "redirect:/assets?presentationYear=" + dto.getPresentationYear() +
                    "&taxType=" + dto.getTaxType() +
                    "&presentationCode=" + dto.getPresentationCode();
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("assetNatures", referenceDataService.getAssetNatures());
            model.addAttribute("assetPositions", referenceDataService.getAssetPositions());
            model.addAttribute("title", "New Asset");
            model.addAttribute("action", "create");
            return "assets/form";
        }
    }

    @GetMapping("/edit/{presentationYear}/{taxType}/{presentationCode}/{assetSequence}")
    public String editAssetForm(@PathVariable String presentationYear,
                                 @PathVariable String taxType,
                                 @PathVariable String presentationCode,
                                 @PathVariable String assetSequence,
                                 Model model) {
        AssetDocumentDTO dto = assetDocumentService.findById(presentationYear, taxType, presentationCode, assetSequence)
                .orElseThrow(() -> new IllegalArgumentException("Asset not found"));
        model.addAttribute("asset", dto);
        model.addAttribute("assetNatures", referenceDataService.getAssetNatures());
        model.addAttribute("assetPositions", referenceDataService.getAssetPositions());
        model.addAttribute("title", "Edit Asset");
        model.addAttribute("action", "update");
        return "assets/form";
    }

    @PostMapping("/update")
    public String updateAsset(@Valid @ModelAttribute("asset") AssetDocumentDTO dto,
                               BindingResult result,
                               Model model,
                               RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("assetNatures", referenceDataService.getAssetNatures());
            model.addAttribute("assetPositions", referenceDataService.getAssetPositions());
            model.addAttribute("title", "Edit Asset");
            model.addAttribute("action", "update");
            return "assets/form";
        }

        try {
            assetDocumentService.update(dto);
            redirectAttributes.addFlashAttribute("successMessage", "Asset updated successfully");
            return "redirect:/assets?presentationYear=" + dto.getPresentationYear() +
                    "&taxType=" + dto.getTaxType() +
                    "&presentationCode=" + dto.getPresentationCode();
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("assetNatures", referenceDataService.getAssetNatures());
            model.addAttribute("assetPositions", referenceDataService.getAssetPositions());
            model.addAttribute("title", "Edit Asset");
            model.addAttribute("action", "update");
            return "assets/form";
        }
    }

    @PostMapping("/delete/{presentationYear}/{taxType}/{presentationCode}/{assetSequence}")
    public String deleteAsset(@PathVariable String presentationYear,
                               @PathVariable String taxType,
                               @PathVariable String presentationCode,
                               @PathVariable String assetSequence,
                               RedirectAttributes redirectAttributes) {
        try {
            assetDocumentService.delete(presentationYear, taxType, presentationCode, assetSequence);
            redirectAttributes.addFlashAttribute("successMessage", "Asset deleted successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/assets?presentationYear=" + presentationYear +
                "&taxType=" + taxType +
                "&presentationCode=" + presentationCode;
    }
}