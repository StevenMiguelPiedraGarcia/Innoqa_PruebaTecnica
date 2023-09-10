package com.techtest.prueba.controller;

import com.techtest.prueba.response.PricesResponse;
import com.techtest.prueba.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/price")
public class PricesController {
    private final PricesService pricesService;

    @Autowired
    public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @GetMapping
    public ResponseEntity<?> getPrice(
            @RequestParam Long brandId,
            @RequestParam Long productId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date applyDate) {
        List<PricesResponse> pricesResponses;
        Map<String, Object> response = new HashMap<>();

        try {
            pricesResponses = pricesService.findPrices(applyDate, productId, brandId);
            return ResponseEntity.ok(pricesResponses);
        } catch (Exception e) {
            response.put("mensaje", "Error en el servidor");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
