package org.techforumist.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.techforumist.jwt.jpa.AppUser;

/**
 * @author Sarath Muraleedharan
 *
 */
public interface UserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findOneByUsername(String username);
}
