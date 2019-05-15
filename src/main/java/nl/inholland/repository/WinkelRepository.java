package nl.inholland.repository;

import nl.inholland.model.Winkel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WinkelRepository extends CrudRepository<Winkel, Long> {

}