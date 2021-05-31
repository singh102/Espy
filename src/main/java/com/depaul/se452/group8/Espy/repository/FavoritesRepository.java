package com.depaul.se452.group8.Espy.repository;

import com.depaul.se452.group8.Espy.model.Favorites;
import com.depaul.se452.group8.Espy.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM images WHERE user_id=?1 ORDER BY created_at DESC")
    Collection<Images> findByUserId(Integer userId);
}

