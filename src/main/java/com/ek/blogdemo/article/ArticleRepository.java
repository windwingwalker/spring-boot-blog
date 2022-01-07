package com.ek.blogdemo.article;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, String> {
    Optional<Article> findByTitle(String title);
}
