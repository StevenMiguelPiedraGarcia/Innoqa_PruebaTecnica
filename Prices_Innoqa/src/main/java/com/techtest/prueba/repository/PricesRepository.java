package com.techtest.prueba.repository;

import com.techtest.prueba.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Integer> {

    @Query("SELECT p FROM Prices p WHERE p.startDate <= :startDate " +
            "AND p.productId = :productId AND p.brandId = :brandId " +
            "ORDER BY p.priority ")// esta es la query que hacemos con los parametro que hemos enviado desde el contrroller,
    List<Prices> findProductPrices(
            @Param("startDate") Date startDate,
            @Param("productId") Long productId,
            @Param("brandId") Long brandId);
}

