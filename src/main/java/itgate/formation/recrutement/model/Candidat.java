package itgate.formation.recrutement.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="type_candidat")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Candidat extends Personne {


    private String prenom;
    private String nom;
    private String  type;


    private String cv;

    private String addres;
    @JsonIgnore
    @OneToMany(mappedBy = "candidat")
    private List<Postuler>  postuler;

    public Candidat(String login, String password, String email, Role role,
                    String prenom, String nom, String type, String cv, String addres, List<Postuler> postuler) {
        super(login, password, email, role);
        this.prenom = prenom;
        this.nom = nom;
        this.type = type;
        this.cv = cv;
        this.addres = addres;
        this.postuler = postuler;
    }


    public Candidat() {

    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresee() {
        return addres;
    }

    public void setAdresee(String adresee) {
        this.addres = adresee;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public List<Postuler> getPostuler() {
        return postuler;
    }

    public void setPostuler(List<Postuler> postuler) {
        this.postuler = postuler;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
