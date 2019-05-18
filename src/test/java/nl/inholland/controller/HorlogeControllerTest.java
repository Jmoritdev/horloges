package nl.inholland.controller;

import nl.inholland.App;
import nl.inholland.controller.HorlogeController;
import nl.inholland.model.Horloge;
import nl.inholland.service.HorlogeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HorlogeController.class)
public class HorlogeControllerTest {

    @Autowired private MockMvc mvc;
    @MockBean private HorlogeService service;
    private Horloge horloge;

    @Before
    public void setup() {
        horloge = new Horloge("Bolex", "Supreme");
    }

    @Test
    public void givenHorloges_whenAllHorlogesShouldReturnJsonArray() throws Exception {
        List<Horloge> allHorloges = Arrays.asList(horloge);
        given(service.getHorloges()).willReturn(allHorloges);

        mvc.perform(get("/horloges"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].brand").value(horloge.getBrand()));
    }

    @Test
    public void whenCreateHorlogeShouldReturnCreated() throws Exception {
        mvc.perform(post("/horloges")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isCreated());

    }
}
