package nl.inholland.model;

import org.apache.tomcat.jni.Local;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import static java.time.temporal.ChronoUnit.SECONDS;

@Entity
public class Horloge {

    @GeneratedValue
    @Id
    private long id;

    private String brand;
    private String name;
    private Period batteryLife;
    private LocalDateTime lastRecharged;

    public Horloge(String brand, String name, Period batteryLife, LocalDateTime lastRecharged){
        this.brand = brand;
        this.name = name;
        this.batteryLife = batteryLife;
        this.lastRecharged = lastRecharged;
    }

    public Horloge(String brand, String name){
        this.brand = brand;
        this.name = name;
        this.batteryLife = Period.ofYears(1);
        this.lastRecharged = LocalDateTime.now();
    }

    public Horloge(){}

    public long getId() {
        return id;
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

    public Period getBatteryLength() {
        return batteryLife;
    }

    public void setBatteryLength(Period batteryLength) {
        this.batteryLife = batteryLength;
    }

    public LocalDateTime getLastRecharged() {
        return lastRecharged;
    }

    public void setLastRecharged(LocalDateTime lastRecharged) {
        this.lastRecharged = lastRecharged;
    }

    /**
     *
     * @return battery left in seconds, 0 if battery is empty
     */
    public long getBatteryLeft(){
        LocalDateTime dateEmpty = lastRecharged.plus(batteryLife);

        return Math.max(0, (LocalDateTime.now().until(dateEmpty, SECONDS))); //return 0 if it is negative
    }

    public boolean rechargeBattery(){
        this.lastRecharged = LocalDateTime.now();

        return true;
    }
}
