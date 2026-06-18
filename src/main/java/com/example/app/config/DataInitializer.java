package com.example.app.config;

import com.example.app.entity.*;
import com.example.app.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProvinceRepository provinceRepository;
    private final MunicipalityRepository municipalityRepository;
    private final CountryRepository countryRepository;
    private final GenericDataRepository genericDataRepository;

    public DataInitializer(ProvinceRepository provinceRepository,
                           MunicipalityRepository municipalityRepository,
                           CountryRepository countryRepository,
                           GenericDataRepository genericDataRepository) {
        this.provinceRepository = provinceRepository;
        this.municipalityRepository = municipalityRepository;
        this.countryRepository = countryRepository;
        this.genericDataRepository = genericDataRepository;
    }

    @Override
    public void run(String... args) {
        initializeProvinces();
        initializeMunicipalities();
        initializeCountries();
        initializeGenericData();
    }

    private void initializeProvinces() {
        if (provinceRepository.count() == 0) {
            Province madrid = new Province();
            madrid.setCode("28");
            madrid.setName("Madrid");
            provinceRepository.save(madrid);

            Province barcelona = new Province();
            barcelona.setCode("08");
            barcelona.setName("Barcelona");
            provinceRepository.save(barcelona);

            Province valencia = new Province();
            valencia.setCode("46");
            valencia.setName("Valencia");
            provinceRepository.save(valencia);
        }
    }

    private void initializeMunicipalities() {
        if (municipalityRepository.count() == 0) {
            Municipality madridCity = new Municipality();
            madridCity.setProvinceCode("28");
            madridCity.setCode("079");
            madridCity.setName("Madrid");
            municipalityRepository.save(madridCity);

            Municipality alcobendas = new Municipality();
            alcobendas.setProvinceCode("28");
            alcobendas.setCode("006");
            alcobendas.setName("Alcobendas");
            municipalityRepository.save(alcobendas);

            Municipality barcelonaCity = new Municipality();
            barcelonaCity.setProvinceCode("08");
            barcelonaCity.setCode("019");
            barcelonaCity.setName("Barcelona");
            municipalityRepository.save(barcelonaCity);
        }
    }

    private void initializeCountries() {
        if (countryRepository.count() == 0) {
            Country spain = new Country();
            spain.setCode("ESP");
            spain.setName("España");
            countryRepository.save(spain);

            Country france = new Country();
            france.setCode("FRA");
            france.setName("Francia");
            countryRepository.save(france);

            Country portugal = new Country();
            portugal.setCode("PRT");
            portugal.setName("Portugal");
            countryRepository.save(portugal);
        }
    }

    private void initializeGenericData() {
        if (genericDataRepository.count() == 0) {
            GenericData urbanNature = new GenericData();
            urbanNature.setDataType("110");
            urbanNature.setDataCode("U");
            urbanNature.setAbbreviation("Urbano");
            urbanNature.setDescription("Bien Urbano");
            genericDataRepository.save(urbanNature);

            GenericData rusticNature = new GenericData();
            rusticNature.setDataType("110");
            rusticNature.setDataCode("R");
            rusticNature.setAbbreviation("Rústico");
            rusticNature.setDescription("Bien Rústico");
            genericDataRepository.save(rusticNature);

            GenericData vehicleNature = new GenericData();
            vehicleNature.setDataType("110");
            vehicleNature.setDataCode("H");
            vehicleNature.setAbbreviation("Vehículo");
            vehicleNature.setDescription("Vehículo");
            genericDataRepository.save(vehicleNature);

            GenericData listedSecurities = new GenericData();
            listedSecurities.setDataType("110");
            listedSecurities.setDataCode("V");
            listedSecurities.setAbbreviation("Val. Cotiz.");
            listedSecurities.setDescription("Valores Cotizados");
            genericDataRepository.save(listedSecurities);

            GenericData unlistedSecurities = new GenericData();
            unlistedSecurities.setDataType("110");
            unlistedSecurities.setDataCode("N");
            unlistedSecurities.setAbbreviation("Val. No Cotiz.");
            unlistedSecurities.setDescription("Valores No Cotizados");
            genericDataRepository.save(unlistedSecurities);

            GenericData bankAccount = new GenericData();
            bankAccount.setDataType("110");
            bankAccount.setDataCode("C");
            bankAccount.setAbbreviation("Cta. Bancaria");
            bankAccount.setDescription("Cuenta Bancaria");
            genericDataRepository.save(bankAccount);

            GenericData businessAsset = new GenericData();
            businessAsset.setDataType("110");
            businessAsset.setDataCode("A");
            businessAsset.setAbbreviation("Act. Empresarial");
            businessAsset.setDescription("Actividad Empresarial");
            genericDataRepository.save(businessAsset);

            GenericData otherAsset = new GenericData();
            otherAsset.setDataType("110");
            otherAsset.setDataCode("T");
            otherAsset.setAbbreviation("Otros");
            otherAsset.setDescription("Otros Bienes");
            genericDataRepository.save(otherAsset);

            GenericData positionP = new GenericData();
            positionP.setDataType("104");
            positionP.setDataCode("P");
            positionP.setAbbreviation("Pleno Dominio");
            positionP.setDescription("Pleno Dominio");
            genericDataRepository.save(positionP);

            GenericData positionG = new GenericData();
            positionG.setDataType("104");
            positionG.setDataCode("G");
            positionG.setAbbreviation("Ganancial");
            positionG.setDescription("Ganancial");
            genericDataRepository.save(positionG);
        }
    }
}