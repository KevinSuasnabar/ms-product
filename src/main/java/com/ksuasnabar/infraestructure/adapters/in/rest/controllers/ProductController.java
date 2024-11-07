package com.ksuasnabar.infraestructure.adapters.in.rest.controllers;

import com.ksuasnabar.application.dto.response.ProductResponseDto;
import com.ksuasnabar.application.services.ProductManagementService;
import com.ksuasnabar.domain.entities.ProductStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "v1")
@RequiredArgsConstructor
public class ProductController {
    private final ProductManagementService productManagementService;

    private final ServletWebServerApplicationContext webServerAppCtxt;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
    public ResponseEntity<List<ProductResponseDto>> findAll(@RequestParam(required = false) ProductStatus status) {
        var port = webServerAppCtxt.getWebServer().getPort();
        var result = productManagementService.findAll(status, port);
        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }
}
