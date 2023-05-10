package itgate.formation.recrutement.dao;

import itgate.formation.recrutement.model.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Administrateur,Long> {
}
