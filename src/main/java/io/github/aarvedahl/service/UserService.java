package io.github.aarvedahl.service;

import io.github.aarvedahl.model.User;

import java.util.List;

/**
 * Created by fan.jin on 2016-10-15.
 */
public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
    void deleteUser(User user);
}
