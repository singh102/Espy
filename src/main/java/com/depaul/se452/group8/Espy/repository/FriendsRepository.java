package com.depaul.se452.group8.Espy.repository;

import java.util.UUID;

import com.depaul.se452.group8.Espy.model.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendsRepository extends JpaRepository<Friends, Integer> {
}
