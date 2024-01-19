package salvatoreassennato.u5.w2.d2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import salvatoreassennato.u5.w2.d2.entities.Author;
import salvatoreassennato.u5.w2.d2.service.AuthorsService;

import java.util.List;

// -------------------------------------------- AUTHORS CRUD -----------------------------------------------
//1) GET http://localhost:3001/authors
//2) GET http://localhost:3001/authors/:id
//3) POST http://localhost:3001/authors(+body)
//4) PUT   http://localhost:3001/authors/:id(+body)
//5) DELETE http://localhost:3001/authors/:id
@RestController
@RequestMapping("/authors")
public class AuthorsController {
   @Autowired
   private AuthorsService authorsService;
    @GetMapping
    public Page<Author> getAuthors(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "id") String orderBy) {
        return authorsService.getAuthors(page,size,orderBy);
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable int id) {
        return authorsService.findById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthors(@RequestBody Author body) {
        return authorsService.save(body);
    }
    @PutMapping("/{id}")
    public Author findByAndUpdate(@PathVariable int id, @RequestBody Author body) {
        return this.authorsService.findByIdAndUpdate(id, body);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id) {
        this.authorsService.findByIdAndDelete(id);
    }
}
