package itgate.formation.recrutement.dao;

import itgate.formation.recrutement.model.Offre;
import itgate.formation.recrutement.model.Postuler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OffreRepository extends JpaRepository<Offre,Long> {


}
