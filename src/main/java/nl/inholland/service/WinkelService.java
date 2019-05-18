package nl.inholland.service;

import nl.inholland.model.Winkel;
import nl.inholland.repository.WinkelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WinkelService {

    private WinkelRepository repository;

    public WinkelService(WinkelRepository repository) {
        this.repository = repository;
    }

    public List<Winkel> getWinkels(){
        return (List<Winkel>) repository.findAll();
    }

    public Winkel getWinkel(long id){
        return repository.findById(id).orElse(null);
    }

    public void saveWinkel(Winkel winkel){
        repository.save(winkel);
    }

    public void deleteWinkel(long id) {
        repository.deleteById(id);
    }

}
