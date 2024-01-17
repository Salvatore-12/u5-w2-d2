package salvatoreassennato.u5.w2.d2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salvatoreassennato.u5.w2.d2.entities.Author;

import java.util.Optional;

@Repository
public interface AuthorsDAO extends JpaRepository<Author,Integer> {
    Optional<Author> findByEmail(String email);
}
