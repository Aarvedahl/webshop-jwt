package org.techforumist.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.techforumist.jwt.jpa.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByArticleid(int articleid);
}
