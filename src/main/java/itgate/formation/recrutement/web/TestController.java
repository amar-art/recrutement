package itgate.formation.recrutement.web;

import itgate.formation.recrutement.dao.TestRepository;
import itgate.formation.recrutement.model.Test;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
public class TestController {

    private TestRepository testRepository;

    public TestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @RequestMapping(value = "/test/save",method = RequestMethod.POST)
    public Test saveTest(@RequestBody Test test){

        return testRepository.save(test);
    }
    @RequestMapping(value = "test/all",method = RequestMethod.GET)
    public List<Test> getAllTest(){
        return testRepository.findAll();
    }
    @RequestMapping(value = "/test/update/{idtest}",method = RequestMethod.PUT)
    public Test updateTest(@RequestBody Test test, @PathVariable Long idtest){

        test.setIdTest(idtest);
        return testRepository.save(test);
    }
    @RequestMapping(value = "test/delete/{idtest}",method = RequestMethod.DELETE)
    public HashMap<String,String> deleteTest(@PathVariable Long idtest){
        HashMap<String,String> hashMap=new HashMap<>();
        try {
            testRepository.deleteById(idtest);
            hashMap.put("etat","test est supprimée avec succes");

        }catch (Exception e){
            hashMap.put("etat","operation refusée");
        }
        return hashMap;
    }

}
