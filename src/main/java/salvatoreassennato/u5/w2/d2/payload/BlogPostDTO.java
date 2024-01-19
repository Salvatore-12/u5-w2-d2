package salvatoreassennato.u5.w2.d2.payload;

import lombok.Getter;
import salvatoreassennato.u5.w2.d2.entities.Categoria;
@Getter
public class BlogPostDTO {
    private String titolo;
    private Categoria categoria;
    private String cover;
    private String contenuto;
    private int authorid;
}
