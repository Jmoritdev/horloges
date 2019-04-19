package nl.inholland.controller;


import nl.inholland.model.Horloge;
import nl.inholland.service.HorlogeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/horloges")
public class HorlogeController {

    private HorlogeService service;

    public HorlogeController(HorlogeService service) {

        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Horloge> getHorloges() {

        return service.getHorloges();
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addHorloge(@RequestBody Horloge horloge) {

        service.addHorloge(horloge);
    }

}
