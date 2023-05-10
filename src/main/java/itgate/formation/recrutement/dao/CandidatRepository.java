package itgate.formation.recrutement.dao;

import itgate.formation.recrutement.model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CandidatRepository extends JpaRepository<Candidat,Long> {
}
