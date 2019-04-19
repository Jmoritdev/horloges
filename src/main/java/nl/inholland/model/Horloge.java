package nl.inholland.model;

public class Horloge {

    private Integer id;
    private String brand;
    private String name;

    public Horloge(Integer id, String brand, String name){
        this.id = id;
        this.brand = brand;
        this.name = name;
    }

    public Horloge(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
