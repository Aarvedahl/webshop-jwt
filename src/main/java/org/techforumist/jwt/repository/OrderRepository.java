package org.techforumist.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.techforumist.jwt.jpa.Purchase;

public interface OrderRepository extends JpaRepository<Purchase, Long> {
}
