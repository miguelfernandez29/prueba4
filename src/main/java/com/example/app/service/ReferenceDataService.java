package com.example.app.service;

import com.example.app.entity.Province;
import com.example.app.entity.Municipality;
import com.example.app.entity.Country;
import com.example.app.entity.GenericData;
import com.example.app.repository.ProvinceRepository;
import com.example.app.repository.MunicipalityRepository;
import com.example.app.repository.CountryRepository;
import com.example.app.repository.GenericDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReferenceDataService {

    private final ProvinceRepository provinceRepository;
    private final MunicipalityRepository municipalityRepository;
    private final CountryRepository countryRepository;
    private final GenericDataRepository genericDataRepository;

    public ReferenceDataService(ProvinceRepository provinceRepository,
                                 MunicipalityRepository municipalityRepository,
                                 CountryRepository countryRepository,
                                 GenericDataRepository genericDataRepository) {
        this.provinceRepository = provinceRepository;
        this.municipalityRepository = municipalityRepository;
        this.countryRepository = countryRepository;
        this.genericDataRepository = genericDataRepository;
    }

    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }

    public Optional<Province> getProvinceByCode(String code) {
        String paddedCode = String.format("%2s", code).replace(' ', '0');
        return provinceRepository.findById(paddedCode);
    }

    public List<Municipality> getMunicipalitiesByProvince(String provinceCode) {
        String paddedCode = String.format("%2s", provinceCode).replace(' ', '0');
        return municipalityRepository.findByProvinceCode(paddedCode);
    }

    public Optional<Municipality> getMunicipalityByCode(String provinceCode, String municipalityCode) {
        String paddedProvince = String.format("%2s", provinceCode).replace(' ', '0');
        String paddedMunicipality = String.format("%3s", municipalityCode).replace(' ', '0');
        return municipalityRepository.findByProvinceCodeAndCode(paddedProvince, paddedMunicipality);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Optional<Country> getCountryByCode(String code) {
        return countryRepository.findById(code);
    }

    public List<GenericData> getAssetNatures() {
        return genericDataRepository.findByDataType("110");
    }

    public List<GenericData> getAssetPositions() {
        return genericDataRepository.findByDataType("104");
    }

    public Optional<GenericData> getGenericDataByTypeAndCode(String dataType, String dataCode) {
        return genericDataRepository.findByDataTypeAndDataCode(dataType, dataCode);
    }
}