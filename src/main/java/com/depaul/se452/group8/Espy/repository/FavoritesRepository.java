package com.depaul.se452.group8.Espy.repository;

import com.depaul.se452.group8.Espy.model.Favorites;
import com.depaul.se452.group8.Espy.model.Images;
import com.depaul.se452.group8.Espy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM images WHERE user_id=?1 ORDER BY created_at DESC")
    Collection<Images> findByUserId(Integer userId);

    Favorites findFavoriteByUserIdAndImageId(Integer userId, Integer imageId);
}

