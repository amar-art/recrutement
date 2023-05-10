package itgate.formation.recrutement.web;


import itgate.formation.recrutement.dao.ResponsableRepository;
import itgate.formation.recrutement.model.Responsable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ResponsableController {

    private ResponsableRepository responsableRepository;

    public ResponsableController(ResponsableRepository responsableRepository) {
        this.responsableRepository = responsableRepository;
    }

    @RequestMapping(value ="/responsable/save")
    public Responsable  saveResponsable(@RequestBody Responsable responsable){

        return responsableRepository.save(responsable);
    }
}
