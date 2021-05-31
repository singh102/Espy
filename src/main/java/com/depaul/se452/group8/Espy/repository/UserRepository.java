package com.depaul.se452.group8.Espy.repository;

import com.depaul.se452.group8.Espy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByUsername(String username);

    List<User> findAllByUsernameContaining(String query);
}

