package salvatoreassennato.u5.w2.d2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import salvatoreassennato.u5.w2.d2.entities.Author;
import salvatoreassennato.u5.w2.d2.exceptions.BadRequestException;
import salvatoreassennato.u5.w2.d2.exceptions.NotFoundException;
import salvatoreassennato.u5.w2.d2.repository.AuthorsDAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class AuthorsService {
    @Autowired
    private AuthorsDAO authorsDAO;

    //1)metodo per ritornare una lista di autori aggiornato tramite DAO Id
    public Page<Author> getAuthors(int page,int size,String orderBy){
        Pageable pageable= PageRequest.of(page,size, Sort.by(orderBy));
        return authorsDAO.findAll(pageable);
    }

    //2)metodo per cercare un autore tramite id aggiornato con DAO
    public Author findById(int id) {
        return authorsDAO.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    //3)medoto per salvare e creare un autore
    public Author save(Author body){

        authorsDAO.findByEmail(body.getEmail()).ifPresent(authors -> {
            throw new BadRequestException("this email " + authors.getEmail() + " is!");
        });
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getName()+body.getSurname());
        return authorsDAO.save(body);

    }
    //4)metodo per ricercare e modicare tramite id un user aggiornato con il DAO
    public Author findByIdAndUpdate(int id, Author body) {
        Author found = this.findById(id);
        found.setName(body.getName());
        found.setSurname(body.getSurname());
        found.setEmail(body.getEmail());
        found.setAvatar(body.getAvatar());
        return authorsDAO.save(found);


    }
    //5)metodo per eliminare un autore tramite  DAO
    public void findByIdAndDelete(int id) {
        Author found=this.findById(id);
        authorsDAO.delete(found);
    }
}
