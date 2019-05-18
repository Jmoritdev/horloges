package nl.inholland.controller;

import nl.inholland.model.Horloge;
import nl.inholland.model.Winkel;
import nl.inholland.service.WinkelService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WinkelController.class)
public class WinkelControllerTest {

    @Autowired private MockMvc mvc;
    @MockBean private WinkelService service;
    private Winkel winkel;

    @Before
    public void setup() {
        winkel = new Winkel("Horloge Winkel 1", new ArrayList<Horloge>());
    }

    @Test
    public void givenWinkels_whenAllWinkelsShouldReturnJsonArray() throws Exception {
        List<Winkel> allWinkels = Arrays.asList(winkel);
        given(service.getWinkels()).willReturn(allWinkels);

        mvc.perform(get("/winkels"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value(winkel.getName()));
    }
}
