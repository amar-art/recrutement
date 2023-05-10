package itgate.formation.recrutement.model;

import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
public class Postuler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;

    @ManyToOne
    @JoinColumn(name = "idOffre")
    private Offre offre;
    @ManyToOne
    @JoinColumn(name = "idcandidat")
    private Candidat candidat;

    public Postuler(Offre offre, Candidat candidat) {
        this.offre = offre;
        this.candidat = candidat;
    }



    public Postuler() {
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }
}
