package salvatoreassennato.u5.w2.d2.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="authors")
@Getter
@Setter
@ToString
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(nullable = false, updatable = false)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String dataDiNascita;
    private String avatar;



}
