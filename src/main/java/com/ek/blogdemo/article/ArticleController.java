package com.ek.blogdemo.article;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    public ArticleService articleService;

    @GetMapping(produces = {"application/json"}) 
    public ResponseEntity<List<Article>> getArticles() { 
        return ResponseEntity.ok(articleService.getArticles());
    }
    
    @GetMapping(value = "/{id}", produces = {"application/json"}) 
    public ResponseEntity<Article> getArticleById(@PathVariable("id") String id) {
        return ResponseEntity.ok(articleService.getArticleById(id));
    }

    @GetMapping(value = "/search/title/{title}", produces = {"application/json"}) 
    public ResponseEntity<Article> getArticleByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(articleService.getArticleByTitle(title));
    }

    @PostMapping(consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Article> addArticle(@RequestBody Article article) { 
        Article res = articleService.addArticle(article);

        URI location = ServletUriComponentsBuilder //to create a url for new created product
            .fromCurrentRequest() //http://…/products
            .path("/{id}") //http://…/products/{id}
            .buildAndExpand(res.getId()) //http://…/products/實際產品編號
            .toUri(); //combine above all thing to a single URL

        return ResponseEntity.created(location).body(res);
    }

    @PutMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Article> updateArticle(@PathVariable("id") String id, @RequestBody Article article) { 
        return ResponseEntity.ok().body(articleService.updateArticle(id, article));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable("id") String id){
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
