package itgate.formation.recrutement.dao;

import itgate.formation.recrutement.model.Candidat;
import itgate.formation.recrutement.model.Offre;
import itgate.formation.recrutement.model.Postuler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@Repository
@CrossOrigin("*")
public interface PostuleRepository extends JpaRepository<Postuler,Long> {

    // @Query("select p from  Postuler p where p.idcandidat=idc  AND p.idoffre=ido"  )

    //public  Postuler recherche(@Param("idc") Long id1,@Param("ido") Long id2);

    //public List<Long>  findAllByIdPost();
    @Query("select o from Postuler as p join p.offre as o join p.candidat as c where c.id= :idcandidat")
    public List<Offre> getAllIdOffre(@Param("idcandidat") Long idcandidat);
    @Query("select c from Postuler as p join p.offre as o join p.candidat as c where o.id= :idoffre")
    public List<Candidat> getAllCandidat(@Param("idoffre") Long idoffre);
}


