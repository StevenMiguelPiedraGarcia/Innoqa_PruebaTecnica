package com.techtest.prueba.response;

import java.util.Date;

public record PricesResponse(
        Long productId,
        Long brandId,
        Integer priceList,
        Date startDate,
        Date endDate,
        Double finalPrice

) {

}





