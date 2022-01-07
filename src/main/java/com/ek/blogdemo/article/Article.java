package com.ek.blogdemo.article;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "articles")
public class Article {
    
    @Id
    private String id;

    private String title;
}
