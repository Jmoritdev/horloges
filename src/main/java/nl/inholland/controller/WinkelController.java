package nl.inholland.controller;

import nl.inholland.model.Winkel;
import nl.inholland.service.WinkelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/winkels")
public class WinkelController {

    private WinkelService service;

    public WinkelController(WinkelService service) {
        this.service = service;
    }

    @GetMapping
    public List<Winkel> getWinkels() {
        return service.getWinkels();
    }

    @PostMapping
    public void saveWinkel(@RequestBody Winkel winkel) {
        service.saveWinkel(winkel);
    }

    @GetMapping(value = "/{id}")
    public Winkel getWinkelById(@PathVariable long id) {
        return service.getWinkel(id);
    }

    @PutMapping
    public void updateWinkel(@RequestBody Winkel winkel) {
        service.saveWinkel(winkel);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteWinkel(@PathVariable long id) {
        service.deleteWinkel(id);
    }


}
