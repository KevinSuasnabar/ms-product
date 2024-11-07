package com.ksuasnabar.application.services;

import com.ksuasnabar.application.dto.response.ProductResponseDto;
import com.ksuasnabar.application.mapper.ProductMapper;
import com.ksuasnabar.domain.entities.ProductStatus;
import com.ksuasnabar.domain.ports.repository.IProductPortRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductManagementService {

    private final IProductPortRepository productPortRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductManagementService(final IProductPortRepository productPortRepository,final ProductMapper productMapper) {
        this.productPortRepository = productPortRepository;
        this.productMapper=productMapper;
    }

    @Transactional(readOnly = true)
    public List<ProductResponseDto> findAll(ProductStatus status, int port){
        log.info("findAll");
        var list = productPortRepository.findAll(status);
        log.info("finded");
        return list.stream().map(p -> productMapper.entityToResponse(p, port)).collect(Collectors.toList());
    }
}
