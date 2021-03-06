package com.depaul.se452.group8.Espy.repository;

import com.depaul.se452.group8.Espy.model.Favorites;
import com.depaul.se452.group8.Espy.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {

    Likes findLikeByUserIdAndImageId(Integer userId, Integer imageId);

}
