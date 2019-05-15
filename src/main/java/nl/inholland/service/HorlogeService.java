package nl.inholland.service;

import nl.inholland.model.Horloge;
import nl.inholland.repository.HorlogeRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class HorlogeService {

    private HorlogeRepository repository;

    public HorlogeService(HorlogeRepository repository) {
        this.repository = repository;
    }

    public List<Horloge> getHorloges(){
        return (List<Horloge>) repository.findAll();
    }

    public Horloge getHorloge(long id){
        return repository.findById(id).orElse(null);
    }

    public void saveHorloge(Horloge h){
        repository.save(h);
    }

    public void deleteHorloge(long id){
        repository.deleteById(id);
    }
}
