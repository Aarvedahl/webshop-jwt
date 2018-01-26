package io.github.aarvedahl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.aarvedahl.jpa.Purchase_article;

public interface Purchase_articleRepository extends JpaRepository<Purchase_article, Long> {
}
