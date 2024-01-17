package salvatoreassennato.u5.w2.d2.service;

import org.springframework.stereotype.Service;
import salvatoreassennato.u5.w2.d2.entities.Author;
import salvatoreassennato.u5.w2.d2.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class AuthorsService {
    private List<Author> authors=new ArrayList<>();
    //1)metodo per ritornare una lista di autori
    public List<Author> getAuthors(){
        return this.authors;
    }

    //2)metodo per cercare un autore tramite id
    public Author findById(int id) {
        Author found = null;
        for (Author author : this.authors) {
            if (author.getId()==id) {
                found = author;
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }

    //3)medoto per salvare e creare un autore
    public Author save(Author body){
        Random rndm= new Random();
        body.setId(rndm.nextInt(1, 1000));
        body.setAvatar("https://ui-avatars.com/api/?name="+body.getName()+body.getSurname());
        this.authors.add(body);
        return body;

    }
    //4)metodo per ricercare e modicare tramite id un user
    public Author findByIdAndUpdate(int id, Author body) {
        Author found = null;
        for (Author author : this.authors) {
            if (author.getId() == id) {
                found = author;
                found.setId(id);
                found.setName(body.getName());
                found.setSurname(body.getSurname());
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }
    //5)metodo per eliminare un user tramite id
    public void findByIdAndDelete(int id) {
        Iterator<Author> iterator = this.authors.iterator();
        while (iterator.hasNext()) {
            Author current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }
}
