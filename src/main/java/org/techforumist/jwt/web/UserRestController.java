package org.techforumist.jwt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.techforumist.jwt.dto.Userdto;
import org.techforumist.jwt.jpa.AppUser;
import org.techforumist.jwt.repository.UserRepository;


@RestController
@RequestMapping(value = "/api")
public class UserRestController {
	@Autowired
	private UserRepository userRepository;


	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<AppUser> users() {
		return userRepository.findAll();
	}


	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<AppUser> userById(@PathVariable Long id) {
		AppUser appUser = userRepository.findOne(id);
		if (appUser == null) {
			return new ResponseEntity<AppUser>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<AppUser>(appUser, HttpStatus.OK);
		}
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/users")
	public List<AppUser> removeUser(@RequestBody Userdto userdto) {
		AppUser user = new AppUser(userdto.getUserid(), userdto.getUsername(), userdto.getPassword(), userdto.isEnabled());
		userRepository.delete(user);
		return users();
	}


	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<AppUser> createUser(@RequestBody AppUser appUser) {
		if (userRepository.findOneByUsername(appUser.getUsername()) != null) {
			throw new RuntimeException("Username already exist");
		}
		return new ResponseEntity<AppUser>(userRepository.save(appUser), HttpStatus.CREATED);
	}

	@PatchMapping
	public void editUser(@RequestBody Userdto userdto) {
		AppUser user = new AppUser(userdto.getUserid(), userdto.getUsername(), userdto.getPassword(), userdto.isEnabled());
		userRepository.save(user);
	}

}
