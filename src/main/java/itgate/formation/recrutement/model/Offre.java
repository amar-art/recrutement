package itgate.formation.recrutement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Offre  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOffre;
    private String nom;
    private  String type;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    @JsonIgnore
    @OneToMany(mappedBy = "offre")
    private List<Postuler> postuler;


    @ManyToOne
    @JoinColumn(name = "idTest")
    private Test test;


    public Offre(String nom, String type, String description, Date date, List<Postuler> postuler, Test test) {
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.date = date;
        this.postuler = postuler;
        this.test = test;
    }

    public Offre() {
    }

    public Long getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(Long idOffre) {
        this.idOffre = idOffre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Postuler> getPostuler() {
        return postuler;
    }

    public void setPostuler(List<Postuler> postuler) {
        this.postuler = postuler;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
