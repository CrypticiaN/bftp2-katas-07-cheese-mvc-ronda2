package com.cheeseworld.app.integration;

import com.cheeseworld.app.Cheese;
import com.cheeseworld.app.CheeseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTests {

    @Autowired
    MockMvc server;

    @Autowired
    CheeseRepository cheeseRepository;

    @BeforeEach
    void setUp() {

        cheeseRepository.deleteAll();

        List<Cheese> allCheeses = List.of(
                new Cheese("Rochefort|stinky french cheese|250gr"),
                new Cheese("Manchego|gourmet discount spanish cheese|100gr"),
                new Cheese("Monterey Jack|creamy discount american cheese|180gr"),
                new Cheese("Cabrales|super stinky cheese|100gr"),
                new Cheese("Aged British Cheddar|british crystalline and flaky cheese|300gr"),
                new Cheese("Smoked Gouda|dutch buttery and crumbly cheese|200gr")
        );

        cheeseRepository.saveAll(allCheeses);
    }

    @Test
    void showsAllTheAvailableCheeseProducts() throws Exception {
        server.perform(get("/cheese/all"))
                .andExpect(view().name("catalog"))
                .andExpect(model().attribute("cheeses", hasItems(
                        hasProperty("name", is("Rochefort")),
                        hasProperty("name", is("Manchego")),
                        hasProperty("name", is("Monterey Jack")),
                        hasProperty("name", is("Cabrales")),
                        hasProperty("name", is("Aged British Cheddar")),
                        hasProperty("name", is("Smoked Gouda"))
                )));
    }

    @Test
    @Disabled
    void showsAllTheStinkyCheeseProducts() throws Exception {
        server.perform(get("/cheese/all"))
                .andExpect(view().name("catalog"))
                .andExpect(model().attribute("cheeses", hasSize(2)))
                .andExpect(model().attribute("cheeses", hasItems(
                        hasProperty("name", is("Rochefort")),
                        hasProperty("name", is("Cabrales"))
                )));
    }
}
