package io.github.aarvedahl.repository;

import io.github.aarvedahl.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByArticleid(int articleid);
}
