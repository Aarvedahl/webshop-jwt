package io.github.aarvedahl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.aarvedahl.jpa.Purchase;

public interface OrderRepository extends JpaRepository<Purchase, Long> {
}
