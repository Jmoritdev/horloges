package nl.inholland.controller;


import nl.inholland.model.Horloge;
import nl.inholland.service.HorlogeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horloges")
public class HorlogeController {

    private HorlogeService service;

    public HorlogeController(HorlogeService service) {
        this.service = service;
        service.addHorloge(new Horloge(1, "Bolex", "Marina"));
        service.addHorloge(new Horloge(2, "Disney", "Mickey Mouse Deluxe"));
        service.addHorloge(new Horloge(3, "Lotus", "Supreme"));
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Horloge> getHorloges() {

        return service.getHorloges();
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addHorloge(@RequestBody Horloge horloge) {

        service.addHorloge(horloge);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Horloge getHorlogeById(@PathVariable int id) {

        return service.getHorloge(id);
    }

    @RequestMapping(value = "{id}/batteryLeft", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public long getBatteryLife(@PathVariable int id) {

        return service.getHorloge(id).getBatteryLeft();
    }

    @RequestMapping(value = "{id}/recharge", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean recharge(@PathVariable int id) {

        return service.getHorloge(id).rechargeBattery();
    }


}
