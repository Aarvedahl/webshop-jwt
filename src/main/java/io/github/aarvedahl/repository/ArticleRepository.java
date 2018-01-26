package io.github.aarvedahl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.aarvedahl.jpa.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByArticleid(int articleid);
}
