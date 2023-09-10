package com.techtest.prueba.service;

import com.techtest.prueba.entity.Prices;
import com.techtest.prueba.repository.PricesRepository;
import com.techtest.prueba.response.PricesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PricesService {
    @Autowired
    PricesRepository pricesRepository;

    public List<PricesResponse> findPrices(Date applyDate, Long productId, Long brandId) {
        // Obtener la lista
        List<Prices> validPrices = pricesRepository.findProductPrices(applyDate, productId, brandId);

        List<PricesResponse> pricesResponses = new ArrayList<>();

        if (!validPrices.isEmpty()) {
            // Ordenar la lista de precios por prioridad de mayor a menor
            validPrices.sort(Comparator.comparingInt(Prices::getPriority));

            // Obtener el precio con la mayor
            Prices highestPriorityPrice = validPrices.get(0);

            // Crear el objeto PricesResponse y agregarlo a la lista de respuesta
            PricesResponse pricesResponse = new PricesResponse(
                    productId,
                    brandId,
                    highestPriorityPrice.getPriceList(),
                    highestPriorityPrice.getStartDate(),
                    highestPriorityPrice.getEndDate(),
                    highestPriorityPrice.getPrice()
            );

            pricesResponses.add(pricesResponse);// con esto añadimos el objeto creado a la List PricesResponse
            return pricesResponses;
        } else {
            return Collections.emptyList();
        }
    }
}