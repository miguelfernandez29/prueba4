package com.example.app.controller.web;

import com.example.app.dto.UrbanAssetDTO;
import com.example.app.service.UrbanAssetService;
import com.example.app.service.ReferenceDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/urban-assets")
public class UrbanAssetWebController {

    private final UrbanAssetService urbanAssetService;
    private final ReferenceDataService referenceDataService;

    public UrbanAssetWebController(UrbanAssetService urbanAssetService,
                                    ReferenceDataService referenceDataService) {
        this.urbanAssetService = urbanAssetService;
        this.referenceDataService = referenceDataService;
    }

    @GetMapping("/new")
    public String newUrbanAssetForm(@RequestParam String presentationYear,
                                     @RequestParam String taxType,
                                     @RequestParam String presentationCode,
                                     @RequestParam String assetSequence,
                                     Model model) {
        UrbanAssetDTO dto = new UrbanAssetDTO();
        dto.setPresentationYear(presentationYear);
        dto.setTaxType(taxType);
        dto.setPresentationCode(presentationCode);
        dto.setAssetSequence(assetSequence);
        dto.setAssetNature("U");
        dto.setCountryCode("ESP");
        populateModel(model, dto, "New Urban Property", "create");
        return "urban-assets/form";
    }

    @GetMapping("/edit/{presentationYear}/{taxType}/{presentationCode}/{assetSequence}")
    public String editUrbanAssetForm(@PathVariable String presentationYear,
                                      @PathVariable String taxType,
                                      @PathVariable String presentationCode,
                                      @PathVariable String assetSequence,
                                      Model model) {
        UrbanAssetDTO dto = urbanAssetService.findById(presentationYear, taxType, presentationCode, assetSequence)
                .orElseThrow(() -> new IllegalArgumentException("Urban asset not found"));
        populateModel(model, dto, "Edit Urban Property", "update");
        return "urban-assets/form";
    }

    @PostMapping("/create")
    public String createUrbanAsset(@Valid @ModelAttribute("urbanAsset") UrbanAssetDTO dto,
                                    BindingResult result,
                                    Model model,
                                    RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            populateModel(model, dto, "New Urban Property", "create");
            return "urban-assets/form";
        }

        try {
            urbanAssetService.create(dto);
            redirectAttributes.addFlashAttribute("successMessage", "Urban property created successfully");
            return "redirect:/assets?presentationYear=" + dto.getPresentationYear() +
                    "&taxType=" + dto.getTaxType() +
                    "&presentationCode=" + dto.getPresentationCode();
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            populateModel(model, dto, "New Urban Property", "create");
            return "urban-assets/form";
        }
    }

    @PostMapping("/update")
    public String updateUrbanAsset(@Valid @ModelAttribute("urbanAsset") UrbanAssetDTO dto,
                                    BindingResult result,
                                    Model model,
                                    RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            populateModel(model, dto, "Edit Urban Property", "update");
            return "urban-assets/form";
        }

        try {
            urbanAssetService.update(dto);
            redirectAttributes.addFlashAttribute("successMessage", "Urban property updated successfully");
            return "redirect:/assets?presentationYear=" + dto.getPresentationYear() +
                    "&taxType=" + dto.getTaxType() +
                    "&presentationCode=" + dto.getPresentationCode();
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            populateModel(model, dto, "Edit Urban Property", "update");
            return "urban-assets/form";
        }
    }

    @PostMapping("/apply-conformity")
    public String applyConformity(@ModelAttribute("urbanAsset") UrbanAssetDTO dto,
                                   Model model) {
        UrbanAssetDTO result = urbanAssetService.applyConformity(dto);
        populateModel(model, result, "Edit Urban Property", "update");
        model.addAttribute("successMessage", "Conformity applied successfully");
        return "urban-assets/form";
    }

    @PostMapping("/apply-reference-value")
    public String applyReferenceValue(@ModelAttribute("urbanAsset") UrbanAssetDTO dto,
                                       Model model) {
        UrbanAssetDTO result = urbanAssetService.applyReferenceValue(dto);
        populateModel(model, result, "Edit Urban Property", "update");
        model.addAttribute("successMessage", "Reference value applied successfully");
        return "urban-assets/form";
    }

    private void populateModel(Model model, UrbanAssetDTO dto, String title, String action) {
        model.addAttribute("urbanAsset", dto);
        model.addAttribute("provinces", referenceDataService.getAllProvinces());
        model.addAttribute("countries", referenceDataService.getAllCountries());
        model.addAttribute("title", title);
        model.addAttribute("action", action);
    }
}