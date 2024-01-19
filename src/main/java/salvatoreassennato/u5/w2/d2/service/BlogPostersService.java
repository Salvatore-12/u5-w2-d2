package salvatoreassennato.u5.w2.d2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import salvatoreassennato.u5.w2.d2.entities.Author;
import salvatoreassennato.u5.w2.d2.entities.BlogPost;
import salvatoreassennato.u5.w2.d2.exceptions.NotFoundException;
import salvatoreassennato.u5.w2.d2.payload.BlogPostDTO;
import salvatoreassennato.u5.w2.d2.repository.BlogPostersDAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostersService {

    @Autowired
    private BlogPostersDAO blogPostersDAO;
    @Autowired
    private AuthorsService authorsService;

    //1)Metodo che ritorna tutti i blogposters tramite il suo DAO
    public Page<BlogPost> getBlogPosters(int page,int size,String orderBy) {
        Pageable pageable= PageRequest.of(page,size, Sort.by(orderBy));
        return blogPostersDAO.findAll(pageable);
    }


   //2)Metodo per ricercare tramite id con il suo DAO
    public BlogPost findById(int id) {
        return blogPostersDAO.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    //3)Metodo per salvare tramite il suo DAO
    public BlogPost save(BlogPostDTO body) {
    Integer authorid= body.getAuthorid();
    Author author=this.authorsService.findById(authorid);
    BlogPost newBlogPost=new BlogPost();
    //SETTAGGIO DELL'AUTORE
    newBlogPost.setAuthor(author);
    //SETTAGGIO CATEGIORIA
     newBlogPost.setCategoria(body.getCategoria());
    //SETTAGGIO TITOLO
     String titolo;
        if (body.getTitolo() == null) {
            titolo = "Nuovo articolo del blog";
        } else {
            titolo = body.getTitolo();
        }
        newBlogPost.setTitolo(titolo);
    //SETTAGGIO CONTENUTO
        String contenuto;
        if (body.getContenuto() == null) {
            contenuto = "";
        } else {
            contenuto = body.getContenuto();
        }
    newBlogPost.setContenuto(contenuto);
     //SETTAGGIO COVER
        String cover;
        if (body.getCover() == null) {
            cover = "https://picsum.photos/200/300";
        } else {
            cover = body.getCover();
        }
        newBlogPost.setCover(cover);
        //SETTAGGIO MINUTI
        int minuti=contenuto.length()/80;
        newBlogPost.setMinuti(minuti);
        blogPostersDAO.save(newBlogPost);
        System.out.println(newBlogPost);
        return newBlogPost;

    }
    //4)metodo per modificare un post aggiornato con il suo DAO
    public BlogPost findByIdAndUpdate(int id, BlogPost body) {
        BlogPost found = this.findById(id);
                 found.setCategoria(body.getCategoria());
                 found.setTitolo(body.getTitolo());
                 found.setContenuto(body.getContenuto());
                 found.setMinuti(body.getMinuti());
                 found.setCover(body.getCover());
        return blogPostersDAO.save(found);
    }
    //5)Metodo per cancellare un post tramite Id aggiornato con il DAO
    public void findByIdAndDelete(int id) {
      BlogPost found=this.findById(id);
      blogPostersDAO.delete(found);
    }
}
