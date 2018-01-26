package org.techforumist.jwt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.techforumist.jwt.dto.Articledto;
import org.techforumist.jwt.jpa.Article;
import org.techforumist.jwt.repository.ArticleRepository;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    List<Article> articles;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public List<Article> getAllArticles() {
        return getArticles();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping
    public List<Article> updateFullArticle(@RequestBody Article article) {
        articleRepository.save(article);
        return getArticles();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping
    public List<Article> updateArticle(@RequestBody Article article) {
        articleRepository.save(article);
        return getArticles();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public List<Article> addArticle(@RequestBody Article article) {
        articleRepository.save(article);
        return getArticles();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping
    public List<Article> deleteArticle(@RequestBody Article article) {
        articleRepository.delete(article);
        return getArticles();
    }


    public List<Article> getArticles() {
        articles = articleRepository.findAll();
        return articles;
    }

}