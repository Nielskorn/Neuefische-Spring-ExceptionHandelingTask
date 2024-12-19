package de.neuefische.springexceptionhandlingtask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class AnimalControllerTest {
    @Autowired
    private MockMvc mvc;
    @Test
    void getAnimalSpecies() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/animals/cat")).
                andExpect(MockMvcResultMatchers.status().isInternalServerError()).andExpect(MockMvcResultMatchers.content().string(containsString("Only 'dog' is allowed")));
    }

    @Test
    void getAllAnimals() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/animals"))
            .andExpect(MockMvcResultMatchers.status().isInternalServerError())
            .andExpect(MockMvcResultMatchers.content().string(containsString("No Animals found")));
    }
}