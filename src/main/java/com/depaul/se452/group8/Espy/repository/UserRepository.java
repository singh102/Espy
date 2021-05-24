package com.depaul.se452.group8.Espy.repository;

import java.util.UUID;
import com.depaul.se452.group8.Espy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

