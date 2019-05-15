package nl.inholland.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Winkel {

    @GeneratedValue
    @Id
    private long id;

    private String name;

    @OneToMany
    private List<Horloge> stock;

    public Winkel(String name, List<Horloge> stock) {
        this.name = name;
        this.stock = stock;
    }

    public Winkel(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Horloge> getStock() {
        return stock;
    }

    public void setStock(List<Horloge> stock) {
        this.stock = stock;
    }

    public void addStock(Horloge horloge){
        stock.add(horloge);
    }
}
