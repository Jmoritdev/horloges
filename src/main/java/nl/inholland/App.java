package nl.inholland;

import nl.inholland.model.Horloge;
import nl.inholland.model.Winkel;
import nl.inholland.repository.HorlogeRepository;
import nl.inholland.repository.WinkelRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@EnableJpaRepositories("nl.inholland.repository") //moest dit toevoegen voordat hij de repositorys kon vinden bij de tests
public class App
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

//    @Bean
//    ApplicationRunner runner(WinkelRepository repository) {
//
//        return args -> {
//            Arrays.asList(
//                    new Winkel("Tijdloos Horlogewinkel", new ArrayList<Horloge>())
//            ).forEach(winkel -> repository.save(winkel));
//
//            repository.findAll().forEach(System.out::println);
//        };
//    }

//    @Bean
//    ApplicationRunner runner2(HorlogeRepository repository) {
//
//        return args -> {
//            Arrays.asList(
//                    new Horloge("Bolex", "Marina"),
//                    new Horloge("Disney", "Mickey Mouse Deluxe"),
//                    new Horloge("Lotus", "Supreme")
//            ).forEach(horloge -> repository.save(horloge));
//
//            repository.findAll().forEach(System.out::println);
//        };
//    }

}

