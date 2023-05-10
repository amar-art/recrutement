package itgate.formation.recrutement.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;

@Entity
public class Responsable extends Personne {


    private String nom;
    private String prenom;


    public Responsable(String login, String password, String email, Role role, String nom, String prenom) {
        super(login, password, email, role);
        this.nom = nom;
        this.prenom = prenom;
    }

    public Responsable(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Responsable() {

    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
