package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public abstract class AbstractIT {
    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
//        RestAssured.port = port;
    }
}
