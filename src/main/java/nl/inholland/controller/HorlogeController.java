package nl.inholland.controller;


import nl.inholland.model.Horloge;
import nl.inholland.service.HorlogeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horloges")
public class HorlogeController {

    private HorlogeService service;

    public HorlogeController(HorlogeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Horloge> getHorloges() {
        return service.getHorloges();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveHorloge(@RequestBody Horloge horloge) {
        service.saveHorloge(horloge);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteHorloge(@PathVariable long id) {
        service.deleteHorloge(id);
    }

    @GetMapping(value = "/{id}")
    public Horloge getHorlogeById(@PathVariable int id) {
        return service.getHorloge(id);
    }

    @GetMapping(value = "{id}/batteryLeft")
    public long getBatteryLife(@PathVariable int id) {
        return service.getHorloge(id).getBatteryLeft();
    }

    @PutMapping
    public void updateHorloge(@RequestBody Horloge horloge) {
        service.saveHorloge(horloge);
    }

    @GetMapping(value = "{id}/recharge")
    public boolean recharge(@PathVariable int id) {
        return service.getHorloge(id).rechargeBattery();
    }


}
