package itgate.formation.recrutement.service;

import itgate.formation.recrutement.model.*;
import org.springframework.web.multipart.MultipartFile;


public interface AccountService {


    Responsable saveResponsable(Responsable responsable);

    Candidat saveCandidat(Candidat candidat,MultipartFile file);


    Administrateur saveAdmin(Administrateur admin);

    Role save(Role role);

    Personne loadUserByUsername(String username);

    void addRoleToUser(String username, String rolename);
}
