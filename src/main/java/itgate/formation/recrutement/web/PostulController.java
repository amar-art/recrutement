package itgate.formation.recrutement.web;

import itgate.formation.recrutement.dao.CandidatRepository;
import itgate.formation.recrutement.dao.OffreRepository;
import itgate.formation.recrutement.dao.PostuleRepository;
import itgate.formation.recrutement.model.Candidat;
import itgate.formation.recrutement.model.Offre;
import itgate.formation.recrutement.model.Postuler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@CrossOrigin("*")
public class PostulController {

    private PostuleRepository jpa;
    private CandidatRepository candidatRepository;
    private OffreRepository offreRepository;

    public PostulController(PostuleRepository jpa, CandidatRepository candidatRepository, OffreRepository offreRepository) {
        this.jpa = jpa;
        this.candidatRepository = candidatRepository;
        this.offreRepository = offreRepository;
    }

    @PostMapping(value = "/postuler/save")
    public Postuler savePostule( Long idcandidat, Long idoffre) {
        Postuler postuler=new Postuler();
        postuler.setCandidat(candidatRepository.getOne(idcandidat));
        postuler.setOffre(offreRepository.getOne(idoffre));
        jpa.save(postuler);
        return  postuler;
    }

    @DeleteMapping(value = "postuler/delete/{id}")
    public HashMap<String,String> deletePostule(@PathVariable Long id){

        HashMap<String,String> hashMap=new HashMap<>();
        try {
            jpa.deleteById(id);
            hashMap.put("etat","objet supprimée avec succes");
        }catch (Exception exp){
            hashMap.put("etat","erreur de supprission car "+exp.getMessage());
        }
        return  hashMap;

    }
    @GetMapping("postuler/getAllId/{idcand}")
    public List<Offre> getallbyid(@PathVariable Long idcand ){



        return  jpa.getAllIdOffre(idcand);
    }
    @GetMapping("postuler/getcandidat/{idoffre}")

    public List<Candidat> getcandidats(@PathVariable Long idoffre){

        return jpa.getAllCandidat(idoffre);
    }
    /*
    @RequestMapping(value = "/postuler/save/{idoffre}",method = RequestMethod.POST)

    public Postuler savePostule(@RequestBody Postuler postuler,@PathVariable Long idoffre){


        postuler.setOffre(offreRepository.getOne(idoffre));
        return jpa.save(postuler);
    }
*/
}
