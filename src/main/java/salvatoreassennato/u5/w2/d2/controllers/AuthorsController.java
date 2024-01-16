package salvatoreassennato.u5.w2.d2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import salvatoreassennato.u5.w2.d2.service.AuthorService;

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
   private AuthorService authorService;
}
