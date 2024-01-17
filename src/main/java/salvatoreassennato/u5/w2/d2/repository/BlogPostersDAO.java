package salvatoreassennato.u5.w2.d2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salvatoreassennato.u5.w2.d2.entities.BlogPost;

@Repository
public interface BlogPostersDAO extends JpaRepository<BlogPost,Integer> {
}
