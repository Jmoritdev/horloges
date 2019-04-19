package nl.inholland.service;

import nl.inholland.model.Horloge;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HorlogeService {

    List<Horloge> horloges = new ArrayList<Horloge>();

    public List<Horloge> getHorloges(){
        return horloges;
    }

    public Horloge getHorloge(int id){
        for(Horloge h : horloges){
            if(h.getId().equals(id)){
                return h;
            }
        }
        return null;
    }

    public void addHorloge(Horloge h){

        horloges.add(h);
    }
}
