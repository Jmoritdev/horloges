package nl.inholland.service;

import nl.inholland.model.Horloge;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class HorlogeService {

    List<Horloge> horloges = new ArrayList<Horloge>();

    public List<Horloge> getHorloges(){
        return horloges;
    }

    public Horloge getHorloge(int id){
        return horloges
                .stream()
                .filter(horloge -> horloge.getId() == id)
                .findFirst().get();
    }

    public void addHorloge(Horloge h){

        horloges.add(h);
    }
}
