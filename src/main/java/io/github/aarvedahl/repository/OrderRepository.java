package io.github.aarvedahl.repository;

import io.github.aarvedahl.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Purchase, Long> {
}
