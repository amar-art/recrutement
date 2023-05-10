package itgate.formation.recrutement.web;


import itgate.formation.recrutement.dao.AdminRepository;
import itgate.formation.recrutement.dao.OffreRepository;
import itgate.formation.recrutement.dao.PersonneRepository;
import itgate.formation.recrutement.dao.TestRepository;
import itgate.formation.recrutement.model.Administrateur;
import itgate.formation.recrutement.model.Offre;
import itgate.formation.recrutement.model.Personne;
import itgate.formation.recrutement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
public class AdminController {

    private AdminRepository adminRepository;
    private OffreRepository offreRepository;
    private TestRepository testRepository;
    private PersonneRepository repository;
    private AccountService accountService;

    public AdminController(AdminRepository adminRepository, OffreRepository offreRepository,
                           TestRepository testRepository, PersonneRepository repository, AccountService accountService) {
        this.adminRepository = adminRepository;
        this.offreRepository = offreRepository;
        this.testRepository = testRepository;
        this.repository = repository;
        this.accountService = accountService;
    }

    @RequestMapping(value = "/admin/save", method = RequestMethod.POST)

    public Administrateur saveAdministrteur(@RequestBody Administrateur admin){

        return accountService.saveAdmin(admin);

    }


    @RequestMapping(value ="/offre/save/{idtest}",method = RequestMethod.POST)
    public Offre saveOffre(@RequestBody Offre offre, @PathVariable Long idtest){

        offre.setTest(testRepository.getOne(idtest));
        return offreRepository.save(offre);
    }
    @RequestMapping(value ="/offre/all" ,method = RequestMethod.GET)
    public List<Offre> getOffre(){

        return offreRepository.findAll();
    }
    @GetMapping("/offre/{id}")
    public Offre getoffre(@PathVariable Long id){
        return offreRepository.getOne(id);
    }

    @RequestMapping(value = "/offre/update/{idoffre}/{idtest}",method = RequestMethod.PUT)
    public Offre updateOffre(@RequestBody Offre offre,@PathVariable Long idoffre,@PathVariable Long idtest){
        offre.setIdOffre(idoffre);
        offre.setTest(testRepository.getOne(idtest));
        return offreRepository.saveAndFlush(offre);

    }
    @RequestMapping(value = "/offre/delete/{idoffre}",method = RequestMethod.DELETE)
    public HashMap<String,String> deleteOffre(@PathVariable Long idoffre){
        HashMap<String,String> hashMap=new HashMap<>();
        try {
            offreRepository.deleteById(idoffre);
            hashMap.put("etat","offre has been deleted ");
        }catch (Exception e){
            hashMap.put("etat","failed operation because  "+e.getMessage());
        }
        return hashMap;
    }

    @RequestMapping(value = "/getprofile",method = RequestMethod.GET)

    public Personne getUser(Principal principal) {
System.out.println(principal.getName());
        Personne appUser = repository.findByLogin(principal.getName());
        System.out.println(appUser);
        return appUser;
    }
}
