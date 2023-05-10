package itgate.formation.recrutement.dao;

import itgate.formation.recrutement.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne,Long> {

    Personne findByLogin(String username);


}
