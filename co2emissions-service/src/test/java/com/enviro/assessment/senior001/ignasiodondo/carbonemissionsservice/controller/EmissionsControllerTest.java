package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.controller;

import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto.EmissionRequestDTO;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto.EmissionResponseDTO;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.mapper.EmissionsMapper;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.model.Emissions;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.repository.EmissionsRepository;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.service.EmissionsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmissionsControllerTest {

    @Mock
    EmissionsRepository emissionsRepository;
    @Mock
    EmissionsMapper emissionsMapper;
    @MockitoSpyBean
    EmissionsService emissionsService;
    @InjectMocks
    EmissionsController emissionsController;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    EmissionRequestDTO emissionsOneReq;
    EmissionResponseDTO emissionsOneRes;
    List<EmissionRequestDTO> emissionsReqList = new ArrayList<>();
    List<EmissionResponseDTO> emissionsResList = new ArrayList<>();
UUID emissionsId = UUID.randomUUID();

    @BeforeEach
    void setUp() {
//        initialise the Request DTOs
        EmissionRequestDTO emissionRequest1DTO = new EmissionRequestDTO();
        emissionRequest1DTO.setEmissionYear("1994");
        emissionRequest1DTO.setCountryId("123e4567-e89b-12d3-a456-426614174002");
        emissionRequest1DTO.setTotalEmissions("84.343391");
        emissionRequest1DTO.setCoalEmissions("0.051302");
        emissionRequest1DTO.setOilEmissions("22.239246");
        emissionRequest1DTO.setGasEmissions("10.066108");
        emissionRequest1DTO.setCementEmissions("1.060089");
        emissionRequest1DTO.setFlaringEmissions("50.926647");
        emissionRequest1DTO.setOtherEmissions("0.111");
        emissionRequest1DTO.setPerCapitaEmissions("0.779603");
        emissionRequest1DTO.setEntryDate("2025-02-03");
        EmissionRequestDTO emissionRequest2DTO = new EmissionRequestDTO();
        emissionRequest2DTO.setEmissionYear("1994");
        emissionRequest2DTO.setCountryId("123e4567-e89b-12d3-a456-426614174001");
        emissionRequest2DTO.setTotalEmissions("84.343391");
        emissionRequest2DTO.setCoalEmissions("0.051302");
        emissionRequest2DTO.setOilEmissions("22.239246");
        emissionRequest2DTO.setGasEmissions("10.066108");
        emissionRequest2DTO.setCementEmissions("1.060089");
        emissionRequest2DTO.setFlaringEmissions("50.926647");
        emissionRequest2DTO.setOtherEmissions("0.111");
        emissionRequest2DTO.setPerCapitaEmissions("0.779603");
        emissionRequest2DTO.setEntryDate("2025-02-03");
//        initialise the Response DTOs
        EmissionResponseDTO emissionResponse1DTO = new EmissionResponseDTO();
        emissionResponse1DTO.setEmissionYear("1994");
        emissionResponse1DTO.setTotalEmissions("84.343391");
        emissionResponse1DTO.setCoalEmissions("0.051302");
        emissionResponse1DTO.setOilEmissions("22.239246");
        emissionResponse1DTO.setGasEmissions("10.066108");
        emissionResponse1DTO.setCementEmissions("1.060089");
        emissionResponse1DTO.setFlaringEmissions("50.926647");
        emissionResponse1DTO.setOtherEmissions("0.111");
        emissionResponse1DTO.setPerCapitaEmissions("0.779603");

        EmissionResponseDTO emissionResponse2DTO = new EmissionResponseDTO();
        emissionResponse2DTO.setEmissionYear("1994");
        emissionResponse2DTO.setTotalEmissions("84.343391");
        emissionResponse2DTO.setCoalEmissions("0.051302");
        emissionResponse2DTO.setOilEmissions("22.239246");
        emissionResponse2DTO.setGasEmissions("10.066108");
        emissionResponse2DTO.setCementEmissions("1.060089");
        emissionResponse2DTO.setFlaringEmissions("50.926647");
        emissionResponse2DTO.setOtherEmissions("0.111");
        emissionResponse2DTO.setPerCapitaEmissions("0.779603");
        emissionsOneReq = emissionRequest1DTO;
        emissionsOneRes = emissionResponse1DTO;
        emissionsResList.add(emissionResponse1DTO);
        emissionsResList.add(emissionResponse2DTO);
        emissionsReqList.add(emissionRequest1DTO);
        emissionsReqList.add(emissionRequest2DTO);
    }

    @AfterEach
    void tearDown() {
        emissionsRepository.deleteAll();
    }


    @Test
    void getAllEmissions() throws Exception {
        when(emissionsService.getEmissions()).thenReturn(emissionsResList);
        this.mockMvc.perform(get("/api/v1/emissions"))
                .andDo(print()).andExpect(status().isOk());
    }

//    @Test
//    void addEmissionShouldAddEmissionSuccessfully(){
//        emissionReqesponse1DTO = emissionsMapper;
//
//        when(emissionsRepository.save(emissionsOneReq)).thenReturn(emissionsOneRes);
//
//        when(emissionsService.createEmission(emissionsOneReq)).thenReturn(emissionsOneRes);
//
//        assertNotNull(addedEmission);
//        assertEquals(product.getId(),addedProduct.getId());
//        assertEquals(product.getName(),addedProduct.getName());
//        assertTrue(product.getId()==1);
//    }

    @Test
    void createEmissions() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v1/emissions", emissionsOneReq)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(emissionsOneReq))
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.emissionYear").value("1994"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.countryId").value("123e4567-e89b-12d3-a456-426614174002"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalEmissions").value("84.343391"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.coalEmissions").value("0.051302"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gasEmissions").value("10.066108"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cementEmissions").value("1.060089"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.flaringEmissions").value("50.926647"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.otherEmissions").value("0.111"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.perCapitaEmissions").value("0.779603"));
    }

    @Test
    void updateEmissions() throws Exception {
        mockMvc.perform(put("/api/v1/emissions/{id}", "123e4567-e89b-12d3-a456-426614174002")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(emissionsOneReq))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.emissionYear").value("1994"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.countryId").value("123e4567-e89b-12d3-a456-426614174002"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalEmissions").value("84.343391"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.coalEmissions").value("0.051302"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gasEmissions").value("10.066108"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cementEmissions").value("1.060089"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.flaringEmissions").value("50.926647"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.otherEmissions").value("0.111"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.perCapitaEmissions").value("0.779603"));

    }

    @Test
    void deleteEmissionShouldDeleteEmissionSuccessfully() throws Exception {
//        when(emissionsService.deleteEmission(UUID.fromString(emissionsOneRes.getEmissionId()));
        this.mockMvc.perform(delete("/api/v1/emissions/" + (emissionsId)))
                .andDo(print()).andExpect(status().isNoContent());

    }

    @Test
    void addEmissionShouldThrowExceptionForInvalidEmissionName() {
        emissionsOneReq.setCountryId("");
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            emissionsService.createEmission(emissionsOneReq);
        });
        assertEquals("Invalid UUID string: ", runtimeException.getMessage());
        verify(emissionsRepository, never()).save(any(Emissions.class));
    }


    @Test
    void testPrivateMethod_validateEmission() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method validateProductName = EmissionsService.class.getDeclaredMethod("validateProductName", String.class);
        validateProductName.setAccessible(true);
        Boolean book = (Boolean) validateProductName.invoke(emissionsService, "Book");
        assertTrue(book);
    }

    @Test
    void testPrivateMethod_validateEmissionIfNameIsInvalid() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method validateProductName = EmissionsService.class.getDeclaredMethod("validateProductName", String.class);
        validateProductName.setAccessible(true);
        Boolean book = (Boolean) validateProductName.invoke(emissionsService, "");
        assertFalse(book);
    }

}