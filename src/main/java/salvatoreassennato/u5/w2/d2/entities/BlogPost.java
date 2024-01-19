package salvatoreassennato.u5.w2.d2.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="blog_posters")
@Getter
@Setter
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int minuti;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id",nullable = false)
    private Author author;

    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", categoria=" + categoria +
                ", titolo='" + titolo + '\'' +
                ", cover='" + cover + '\'' +
                ", contenuto='" + contenuto + '\'' +
                ", minuti=" + minuti +
                ", author=" + author.getSurname() +
                '}';
    }
}
