package nl.inholland.model;

import nl.inholland.model.Horloge;
import org.junit.Before;
import org.junit.Test;

import java.time.Period;

import static org.junit.Assert.*;

public class HorlogeTest {

    Horloge horloge;

    @Before
    public void setUp(){
        horloge = new Horloge("Rolex", "Supreme");
    }

    @Test
    public void createHorlogeShouldNotBeNull() {
        assertNotNull(horloge);
    }

    @Test
    public void defaultBatteryLifeIsOneYear(){
        assertEquals(Period.ofYears(1), horloge.getBatteryLength());
    }

    @Test
    public void noBatteryLeftReturnsZero(){
        horloge.setBatteryLength(Period.ofYears(0));
        assertEquals(0, horloge.getBatteryLeft());
        horloge.setBatteryLength(Period.ofYears(1));
    }
}