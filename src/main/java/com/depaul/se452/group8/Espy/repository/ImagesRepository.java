package com.depaul.se452.group8.Espy.repository;

import com.depaul.se452.group8.Espy.model.Friends;
import com.depaul.se452.group8.Espy.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM images WHERE user_id IN (SELECT friend_id FROM friends WHERE user_id=?1 OR friend_id=?1) ORDER BY created_at ASC")
    Collection<Images> findByUserIds(Integer userId);
}

