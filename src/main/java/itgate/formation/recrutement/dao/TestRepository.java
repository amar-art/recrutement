package itgate.formation.recrutement.dao;

        import itgate.formation.recrutement.model.Test;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test,Long> {
}
