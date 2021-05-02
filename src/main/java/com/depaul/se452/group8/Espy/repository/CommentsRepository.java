package com.depaul.se452.group8.Espy.repository;

import java.util.UUID;

import com.depaul.se452.group8.Espy.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long>   {
}
