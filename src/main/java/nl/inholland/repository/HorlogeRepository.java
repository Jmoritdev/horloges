package nl.inholland.repository;

import nl.inholland.model.Horloge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorlogeRepository extends CrudRepository<Horloge, Long> {

}