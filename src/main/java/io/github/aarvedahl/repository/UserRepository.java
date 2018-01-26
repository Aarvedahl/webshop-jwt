package io.github.aarvedahl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.aarvedahl.jpa.AppUser;

/**
 * @author Sarath Muraleedharan
 *
 */
public interface UserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findOneByUsername(String username);
}
