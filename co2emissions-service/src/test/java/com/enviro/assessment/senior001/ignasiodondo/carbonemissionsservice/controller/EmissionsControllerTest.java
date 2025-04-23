package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.controller;

import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto.CountryRequestDTO;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto.EmissionRequestDTO;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto.CountryResponseDTO;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto.EmissionResponseDTO;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.model.Emissions;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.repository.EmissionsRepository;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.service.EmissionsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmissionsControllerTest {
    String token = "";
    @MockitoSpyBean
    EmissionsRepository emissionsRepository;
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
    void setUp() throws Exception {
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

//        Country stuff here
        CountryResponseDTO countryResponse1DTO = new CountryResponseDTO();
        countryResponse1DTO.setName("Nigeria");
        countryResponse1DTO.setCode("NGA");
        countryResponse1DTO.setUN_M49("566");
        countryResponse1DTO.setRegisteredDate("2025-02-03");

        CountryResponseDTO countryResponse2DTO = new CountryResponseDTO();
        countryResponse2DTO.setName("South Africa");
        countryResponse2DTO.setCode("ZAF");
        countryResponse2DTO.setUN_M49("710");
        countryResponse2DTO.setRegisteredDate("2025-02-03");
//        country entries
        //        initialise the Request DTOs
        CountryRequestDTO countryRequest1DTO = new CountryRequestDTO();
        countryRequest1DTO.setName("South Africa");
        countryRequest1DTO.setCode("123e4567-e89b-12d3-a456-426614174002");
        countryRequest1DTO.setUN_M49(710);
        countryRequest1DTO.setRegisteredDate(LocalDate.parse("2025-02-03"));

        CountryRequestDTO countryRequest2DTO = new CountryRequestDTO();
        countryRequest2DTO.setName("Egypt");
        countryRequest2DTO.setCode("123e4567-e89b-12d3-a456-426614174001");
        countryRequest2DTO.setUN_M49(818);
        countryRequest2DTO.setRegisteredDate(LocalDate.parse("2025-02-03"));
        emissionsOneReq = emissionRequest1DTO;
        emissionsOneRes = emissionResponse1DTO;
        emissionsResList.add(emissionResponse1DTO);
        emissionsResList.add(emissionResponse2DTO);
        emissionsReqList.add(emissionRequest1DTO);
        emissionsReqList.add(emissionRequest2DTO);
//        Extracting the token from auth endpoint
        String username = "admin";
        String password = "admin1234";
        token = obtainBearerToken(username, password);
    }

    @AfterAll
    void tearDown() {
        emissionsRepository.deleteAll();
    }

    @Test
    public void testShould_Be_Able_To_GetAllEmissionsWithBearerToken() throws Exception {
        this.mockMvc.perform(get("/api/v1/emissions")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void Should_AddEmissionShouldAddEmissionSuccessfully() {

        when(emissionsService.createEmission(emissionsOneReq)).thenReturn(emissionsOneRes);
        assertNotNull(emissionsOneRes);
    }

    @Test
    void Should_BeAble_ToCreateEmissionSuccessfullyWithBearerToken() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v1/emissions", emissionsOneReq)
                                .header("Authorization", "Bearer " + token)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(emissionsOneReq))
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(jsonPath("$.emissionYear").value("1994"))
                .andExpect(jsonPath("$.countryId").value("123e4567-e89b-12d3-a456-426614174002"))
                .andExpect(jsonPath("$.totalEmissions").value("84.343391"))
                .andExpect(jsonPath("$.coalEmissions").value("0.051302"))
                .andExpect(jsonPath("$.gasEmissions").value("10.066108"))
                .andExpect(jsonPath("$.cementEmissions").value("1.060089"))
                .andExpect(jsonPath("$.flaringEmissions").value("50.926647"))
                .andExpect(jsonPath("$.otherEmissions").value("0.111"))
                .andExpect(jsonPath("$.perCapitaEmissions").value("0.779603"));
    }

    @Test
    void Should_BeAble_To_UpdateEmissionSuccessfully() throws Exception {
        // Arrange
        Emissions newEmission = new Emissions();
        newEmission.setEmissionId(UUID.fromString("d6d85872-05ac-4650-b08e-f3165a196a17"));
        newEmission.setEmissionYear("1995");
        newEmission.setCountryId(UUID.fromString("123e4567-e89b-12d3-a456-426614174002"));
        newEmission.setTotalEmissions(84.343391);
        newEmission.setCoalEmissions(0.051302);
        newEmission.setOilEmissions(22.239246);
        newEmission.setGasEmissions(10.066108);
        newEmission.setCementEmissions(1.060089);
        newEmission.setFlaringEmissions(50.926647);
        newEmission.setOtherEmissions(0.111);
        newEmission.setPerCapitaEmissions(0.779603);
//      EmissionRequestDTO && properties
        EmissionRequestDTO emissionRequest1DTO = new EmissionRequestDTO();
        emissionRequest1DTO.setEmissionYear("1995");
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
//      @Request
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
        String updatedResourceJson = objectMapper.writeValueAsString(emissionRequest2DTO);
//@Response
        EmissionResponseDTO emissionResponse2DTO = new EmissionResponseDTO();
        emissionResponse2DTO.setEmissionYear("1994");
        emissionResponse2DTO.setCountryId("123e4567-e89b-12d3-a456-426614174001");
        emissionResponse2DTO.setTotalEmissions("84.343391");
        emissionResponse2DTO.setCoalEmissions("0.051302");
        emissionResponse2DTO.setOilEmissions("22.239246");
        emissionResponse2DTO.setGasEmissions("10.066108");
        emissionResponse2DTO.setCementEmissions("1.060089");
        emissionResponse2DTO.setFlaringEmissions("50.926647");
        emissionResponse2DTO.setOtherEmissions("0.111");
        emissionResponse2DTO.setPerCapitaEmissions("0.779603");
        when(emissionsRepository.findById(UUID.fromString(("d6d85872-05ac-4650-b08e-f3165a196a17")))).thenReturn(Optional.of(newEmission));
//      Am supposed to find that created emission using emissionsService

        newEmission.setOtherEmissions(Double.valueOf("0.2222"));

//      creating an emission to be updated late
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v1/emissions", emissionsOneReq)
                                .header("Authorization", "Bearer " + token)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(emissionsOneReq))
                )
                .andExpect(MockMvcResultMatchers.status().isCreated());
        MockMvcResultMatchers.content().json(updatedResourceJson);
        // Act & Assert

    }

//

    @Test
    void Should_DeleteEmissionShouldDeleteEmissionSuccessfullyWithBearerToken() throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/v1/emissions/" + (emissionsId))
                                .header("Authorization", "Bearer " + token)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(emissionsOneReq))
                )
                .andDo(print()).andExpect(status().isNoContent());

    }


    @Test
    void addEmissionShouldThrowExceptionForInvalidEmissionName() {
        emissionsOneReq.setCountryId("");
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> emissionsService.createEmission(emissionsOneReq));
        assertEquals("Invalid UUID string: ", runtimeException.getMessage());
        verify(emissionsRepository, never()).save(any(Emissions.class));
    }

    @Test
    public void canRetrieveByIdWhenExists() throws Exception {

        // Arrange
        // Act and Assert
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/emissions/" + (emissionsId))
                                .header("Authorization", "Bearer " + token)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(emissionsOneReq))
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Sql(scripts = {"/data.sql"},
            config = @SqlConfig(encoding = "utf-8", transactionMode = SqlConfig.TransactionMode.ISOLATED))
    public void testLoadDataForTestCase() {
        assertEquals(5, emissionsRepository.findAll().size());
    }

    private String obtainBearerToken(String username, String password) throws Exception {

        Map<String, String> requestBody = Map.of(
                "username", username,
                "password", password
        );

        ObjectMapper objectMapper = new ObjectMapper();
        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8081/authenticate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(requestBody)))
                        .andExpect(status().isOk());
        return result.andReturn().getResponse().getContentAsString();
    }
}