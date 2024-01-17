package salvatoreassennato.u5.w2.d2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="blog_posters")
@Getter
@Setter
@ToString
public class BlogPost {
    private int id;
    private Categoria categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int minuti;
}
