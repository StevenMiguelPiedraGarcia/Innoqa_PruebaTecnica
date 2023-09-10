package com.techtest.prueba.service;

import com.techtest.prueba.controller.PricesController;
import com.techtest.prueba.response.PricesResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceServiceJUnitTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testScenario1() throws Exception {
        // Configura la fecha y hora para la petición (10:00 del día 14)
        Date requestDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-09-14 10:00:00");

        // Mockear el servicio de precios
        PricesService pricesService = mock(PricesService.class);

        // Crear una lista de PricesResponse mockeados para esta prueba
        List<PricesResponse> mockPrices = new ArrayList<>();
        mockPrices.add(new PricesResponse(
                35455L,
                1L,
                1, // Precio simulado
                new Date(),
                new Date(),
                35.50 // Precio simulado
        ));

        // Configurar el comportamiento del servicio mockado
        when(pricesService.findPrices(any(Date.class), anyLong(), anyLong())).thenReturn(mockPrices);

        // Crear una instancia del controlador y pasar el servicio mockado al constructor
        PricesController pricesController = new PricesController(pricesService);

        // Realizar la solicitud GET para la prueba 1
        mockMvc.perform(MockMvcRequestBuilders.get("/price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applyDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(requestDate))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testScenario2() throws Exception {
        // Configura la fecha y hora para la petición (16:00 del día 14)
        Date requestDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-09-14 16:00:00");


        PricesService pricesService = mock(PricesService.class);

        List<PricesResponse> mockPrices = new ArrayList<>();
        mockPrices.add(new PricesResponse(
                35455L,
                1L,
                2,
                new Date(),
                new Date(),
                25.45
        ));


        when(pricesService.findPrices(any(Date.class), anyLong(), anyLong())).thenReturn(mockPrices);

        PricesController pricesController = new PricesController(pricesService);

        // Realizar la solicitud GET para la prueba 2
        mockMvc.perform(MockMvcRequestBuilders.get("/price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applyDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(requestDate))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testScenario3() throws Exception {
        // Configura la fecha y hora para la petición (21:00 del día 14)
        Date requestDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-09-14 21:00:00");

        PricesService pricesService = mock(PricesService.class);

        List<PricesResponse> mockPrices = new ArrayList<>();
        mockPrices.add(new PricesResponse(
                35455L,
                1L,
                1,
                new Date(),
                new Date(),
                35.50
        ));

        when(pricesService.findPrices(any(Date.class), anyLong(), anyLong())).thenReturn(mockPrices);

        PricesController pricesController = new PricesController(pricesService);

        // Realizar la solicitud GET para la prueba 3
        mockMvc.perform(MockMvcRequestBuilders.get("/price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applyDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(requestDate))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testScenario4() throws Exception {
        // Configura la fecha y hora para la petición (10:00 del día 15)
        Date requestDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-09-15 10:00:00");

        PricesService pricesService = mock(PricesService.class);

        List<PricesResponse> mockPrices = new ArrayList<>();
        mockPrices.add(new PricesResponse(
                35455L,
                1L,
                3,
                new Date(),
                new Date(),
                30.50
        ));


        when(pricesService.findPrices(any(Date.class), anyLong(), anyLong())).thenReturn(mockPrices);

        PricesController pricesController = new PricesController(pricesService);

        mockMvc.perform(MockMvcRequestBuilders.get("/price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applyDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(requestDate))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testScenario5() throws Exception {
        // Configura la fecha y hora para la petición (21:00 del día 16)
        Date requestDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-09-16 21:00:00");

        PricesService pricesService = mock(PricesService.class);

        List<PricesResponse> mockPrices = new ArrayList<>();
        mockPrices.add(new PricesResponse(
                35455L,
                1L,
                4,
                new Date(),
                new Date(),
                40.50
        ));


        when(pricesService.findPrices(any(Date.class), anyLong(), anyLong())).thenReturn(mockPrices);

        PricesController pricesController = new PricesController(pricesService);

        mockMvc.perform(MockMvcRequestBuilders.get("/price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applyDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(requestDate))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}
