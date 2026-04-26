package com.example.MIS.and.Invoicing.System.groupmanagement.service;

import com.example.MIS.and.Invoicing.System.groupmanagement.dto.BrandDTO;
import com.example.MIS.and.Invoicing.System.groupmanagement.entity.BrandEntity;
import com.example.MIS.and.Invoicing.System.groupmanagement.entity.ChainEntity;
import com.example.MIS.and.Invoicing.System.groupmanagement.repository.BrandRepository;
import com.example.MIS.and.Invoicing.System.groupmanagement.repository.ChainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;
    private final ChainRepository chainRepository;

    public BrandService(BrandRepository brandRepository, ChainRepository chainRepository) {
        this.brandRepository = brandRepository;
        this.chainRepository = chainRepository;
    }

    public BrandEntity addBrand(BrandDTO brandDTO) {
        if (brandRepository.existsByBrandNameAndIsActiveTrue(brandDTO.getBrandName())) {
            throw new RuntimeException("Brand name already exists");
        }
        ChainEntity chain = chainRepository.findById(brandDTO.getChainId().longValue())
                .orElseThrow(() -> new RuntimeException("Chain not found"));
        BrandEntity brand = new BrandEntity();
        brand.setBrandName(brandDTO.getBrandName());
        brand.setChain(chain);
        brand.setActive(true);
        return brandRepository.save(brand);
    }

    public List<BrandEntity> getAllBrands() {
        return brandRepository.findAllByIsActiveTrue();
    }

    public BrandEntity updateBrand(Long id, BrandDTO brandDTO) {
        BrandEntity brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        if (brandRepository.existsByBrandNameAndIsActiveTrue(brandDTO.getBrandName())) {
            throw new RuntimeException("Brand name already taken");
        }
        brand.setBrandName(brandDTO.getBrandName());
        return brandRepository.save(brand);
    }

    public String deleteBrand(Long id) {
        BrandEntity brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        brand.setActive(false);
        brandRepository.save(brand);
        return "Brand deleted successfully";
    }
}
