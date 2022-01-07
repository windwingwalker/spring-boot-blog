package com.ek.blogdemo.article;

import com.ek.blogdemo.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(String id) {
        return articleRepository.findById(id)
            .orElseThrow(ResourceNotFoundException::new);
    }

    public Article getArticleByTitle(String title) {
        return articleRepository.findByTitle(title)
            .orElseThrow(ResourceNotFoundException::new);
    }

    public Article addArticle(Article article){
        Article res = new Article();
        res.setTitle(article.getTitle());
        articleRepository.save(res);
        return res;
    }

    public Article updateArticle(String id, Article article){
        Article res = getArticleById(id);
        res.setTitle(article.getTitle());
        articleRepository.save(res);
        return res;
    }

    public void deleteArticle(String id){
        articleRepository.deleteById(id);
    }
    
}
