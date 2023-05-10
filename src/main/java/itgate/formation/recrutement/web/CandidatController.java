package itgate.formation.recrutement.web;


import itgate.formation.recrutement.dao.CandidatRepository;
import itgate.formation.recrutement.dao.OffreRepository;
import itgate.formation.recrutement.file.StorageService;
import itgate.formation.recrutement.model.Candidat;
import itgate.formation.recrutement.service.AccountService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
public class CandidatController {

    private OffreRepository offreRepository;
    private CandidatRepository candidatRepository;
    private AccountService accountService;
    private StorageService storageService;

    public CandidatController(StorageService storageService,OffreRepository offreRepository, CandidatRepository candidatRepository, AccountService accountService) {
        this.offreRepository = offreRepository;
        this.candidatRepository = candidatRepository;
        this.accountService = accountService;
        this.storageService = storageService;
    }

    @RequestMapping(value = "/candidat/save",method = RequestMethod.POST)
    public Candidat saveCandidat(Candidat candidat,@PathParam("file") MultipartFile file){


        return accountService.saveCandidat(candidat,file);

    }
       @RequestMapping(value ="candidat/get/{id}",method = RequestMethod.GET)
    public Candidat getCandidat(@PathVariable Long id){
        return candidatRepository.getOne(id);
    }

    @RequestMapping(value ="candidat/update/{id}",method = RequestMethod.PUT)
    public Candidat updatecandidat(@PathVariable Long id,Candidat candidat,@PathParam("file") MultipartFile file){
        Candidat candidat1=candidatRepository.getOne(id);
         storageService.store(file);
         candidat.setCv(file.getOriginalFilename());
        candidat.setRole(candidat1.getRole());
        candidat.setPassword(candidat1.getPassword());
        candidat.setLogin(candidat1.getLogin());
        return candidatRepository.saveAndFlush(candidat);
    }



    @RequestMapping(value ="candidat/getall",method = RequestMethod.GET)

    public List<Candidat> getAllCandidat(){
        return candidatRepository.findAll();
    }

    @RequestMapping(value = "candidat/delete/{id}", method = RequestMethod.DELETE)
    public HashMap<String,String> deletecandidat(@PathVariable Long id){
        HashMap<String,String> hashMap=new HashMap<>();
        try {
            candidatRepository.deleteById(id);
            hashMap.put("","supprimer avec succes");
        } catch (Exception exp){
            hashMap.put("","failed car "+exp.getMessage());
        }
        return hashMap;
    }
}
