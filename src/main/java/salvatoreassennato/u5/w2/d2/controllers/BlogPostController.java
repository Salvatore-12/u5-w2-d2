package salvatoreassennato.u5.w2.d2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import salvatoreassennato.u5.w2.d2.entities.Author;
import salvatoreassennato.u5.w2.d2.entities.BlogPost;
import salvatoreassennato.u5.w2.d2.payload.BlogPostDTO;
import salvatoreassennato.u5.w2.d2.service.BlogPostersService;
// -------------------------------------------- BLOGS CRUD -----------------------------------------------
//1) GET http://localhost:3001/blogs
//2) GET http://localhost:3001/blogs/:id
//3) POST http://localhost:3001/blogs(+body)
//4) PUT   http://localhost:3001/blogs/:id(+body)
//5) DELETE http://localhost:3001/blogs/:id
@RestController
@RequestMapping("/blogs")
public class BlogPostController {
    @Autowired
    private BlogPostersService blogPostersService;

    @GetMapping
    public Page<BlogPost> getBlogPosters(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(defaultValue = "id") String orderBy) {
        return blogPostersService.getBlogPosters(page,size,orderBy);
    }

    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable int id) {
        return blogPostersService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveAuthors(@RequestBody BlogPostDTO body) {
        return blogPostersService.save(body);
    }

    @PutMapping("/{id}")
    public BlogPost findByAndUpdate(@PathVariable int id, @RequestBody BlogPost body) {
        return this.blogPostersService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id) {
        this.blogPostersService.findByIdAndDelete(id);
    }
}
