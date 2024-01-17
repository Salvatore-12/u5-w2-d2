package salvatoreassennato.u5.w2.d2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Entity
@Table(name="authors")
@Getter
@Setter
@ToString
public class Author {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private String email;
    private String dataDiNascita;
    private String avatar;

}
