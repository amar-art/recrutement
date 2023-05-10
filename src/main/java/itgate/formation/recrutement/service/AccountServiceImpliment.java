package itgate.formation.recrutement.service;



import itgate.formation.recrutement.dao.PersonneRepository;
import itgate.formation.recrutement.dao.RoleRepository;
import itgate.formation.recrutement.file.StorageService;
import itgate.formation.recrutement.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

@Service

@Transactional
public class AccountServiceImpliment implements AccountService {
    @Autowired
    StorageService storageService;

    private PersonneRepository userRepository;

    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public AccountServiceImpliment(PersonneRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    //recherche de user
    public Personne loadUserByUsername(String username) {
        return userRepository.findByLogin(username);
    }


    @Override
//  //affectation de role d'utilisateur
    public void addRoleToUser(String login, String rolename) {

        Personne appUser = userRepository.findByLogin(login);
        Role appRole = roleRepository.findByNomRole(rolename);

        appUser.setRole(appRole);
        //userRepository.save(appUser);
    }




    @Override
    //ajouter une role
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Responsable saveResponsable(Responsable responsable) {
        Personne user = userRepository.findByLogin(responsable.getLogin());

        if (user != null) throw new RuntimeException("User already exists");

        Responsable appUser = new Responsable();
        appUser.setLogin(responsable.getLogin());

        appUser.setNom(responsable.getNom());
        appUser.setPrenom(responsable.getPrenom());
        appUser.setEmail(responsable.getEmail());



        appUser.setPassword(bCryptPasswordEncoder.encode(responsable.getPassword()));


        Role role = roleRepository.findByNomRole("responsable");
        if (role != null) {
            appUser.setRole(role);
            userRepository.save(appUser);
        }

        return appUser;
    }

    @Override
    public Candidat saveCandidat(Candidat candidat,MultipartFile file) {
        Personne user = userRepository.findByLogin(candidat.getLogin());

        if (user != null) throw new RuntimeException("User already exists");

        Candidat appUser = new Candidat();
        appUser.setLogin(candidat.getLogin());
        System.out.println("sauvgarder file"+file);
        storageService.store(file);
appUser.setCv(file.getOriginalFilename());


        appUser.setNom(candidat.getNom());
        appUser.setPrenom(candidat.getPrenom());
        appUser.setEmail(candidat.getEmail());
        appUser.setAdresee(candidat.getAdresee());
        appUser.setType(candidat.getType());




        appUser.setPassword(bCryptPasswordEncoder.encode(candidat.getPassword()));


        Role role = roleRepository.findByNomRole("candidat");
        if (role != null) {
            appUser.setRole(role);
            userRepository.save(appUser);
        }

        return appUser;
    }

    @Override
    public Administrateur saveAdmin(Administrateur admin) {
        Personne user = userRepository.findByLogin(admin.getLogin());

        if (user != null) throw new RuntimeException("User already exists");

        Administrateur appUser = new Administrateur();
        appUser.setLogin(admin.getLogin());



        appUser.setEmail(admin.getEmail());





        appUser.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));


        Role role = roleRepository.findByNomRole("admin");
        if (role != null) {
            appUser.setRole(role);
            userRepository.save(appUser);
        }

        return appUser;
    }


}

