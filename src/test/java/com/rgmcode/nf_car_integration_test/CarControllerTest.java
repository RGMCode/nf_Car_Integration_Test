package com.rgmcode.nf_car_integration_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getAllProducts_shouldReturnEmptyList_whenRepositoryIsEmpty() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/car/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    // ---------------------- GetMapping ----------------------
    @DirtiesContext
    @Test
    void getAllCars_shouldReturnListWithOneObject_whenOneObjectWasSavedInRepository() throws Exception {
        Car car = new Car("1", "BMW", 4, true);
        CarRepository.addCar(car);

        mvc.perform(MockMvcRequestBuilders.get("/api/car/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                [
                                 {
                                     "id": "1",
                                     "manufacturer": "BMW",
                                     "tires": 4,
                                     "tuv": true
                                 }
                                ]
                                """
                ));
    }

    // ---------------------- PostMapping ----------------------
    @DirtiesContext
    @Test
    void addCar_shouldReturnPostCar() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/car/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                                {
                                            "id": "1",
                                            "manufacturer": "BMW",
                                            "tires": 4,
                                            "tuv": true
                                        }
                                               """
                        ))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/api/car/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                [
                                 {
                                     "id": "1",
                                     "manufacturer": "BMW",
                                     "tires": 4,
                                     "tuv": true
                                 }
                                ]
                                """
                ));
    }

    @DirtiesContext
    @Test
    void deleteCar_shouldReturnDeleteCar() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/car/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                                {
                                            "id": "1",
                                            "manufacturer": "BMW",
                                            "tires": 4,
                                            "tuv": true
                                        }
                                               """
                        ))
                .andExpect(MockMvcResultMatchers.status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/api/car/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                [
                                 {
                                     "id": "1",
                                     "manufacturer": "BMW",
                                     "tires": 4,
                                     "tuv": true
                                 }
                                ]
                                """
                ));
        mvc.perform(MockMvcRequestBuilders.delete("/api/car/{id}", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                                {
                                            "id": "1",
                                            "manufacturer": "BMW",
                                            "tires": 4,
                                            "tuv": true
                                        }
                                               """
                        ))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }


    @DirtiesContext
    @Test
    void updateCar_shouldReturnDeleteCar() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/car/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                                {
                                            "id": "1",
                                            "manufacturer": "BMW",
                                            "tires": 4,
                                            "tuv": true
                                        }
                                               """
                        ))
                .andExpect(MockMvcResultMatchers.status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/api/car/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                [
                                 {
                                     "id": "1",
                                     "manufacturer": "BMW",
                                     "tires": 4,
                                     "tuv": true
                                 }
                                ]
                                """
                ));
        mvc.perform(MockMvcRequestBuilders.put("/api/car/{id}", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                                {
                                            "id": "1",
                                            "manufacturer": "Volvo",
                                            "tires": 4,
                                            "tuv": true
                                        }
                                               """
                        ))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }
}