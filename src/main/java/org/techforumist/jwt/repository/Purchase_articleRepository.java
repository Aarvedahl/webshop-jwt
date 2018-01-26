package org.techforumist.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.techforumist.jwt.jpa.Purchase_article;

public interface Purchase_articleRepository extends JpaRepository<Purchase_article, Long> {
}
