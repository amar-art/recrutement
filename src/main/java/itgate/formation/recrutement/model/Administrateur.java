package itgate.formation.recrutement.model;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;

@Entity
public class Administrateur extends Personne {


    public Administrateur(String login, String password, String email, Role role) {
        super(login, password, email, role);
    }

    public Administrateur() {

    }

}
