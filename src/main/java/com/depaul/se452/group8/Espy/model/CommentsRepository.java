package com.depaul.se452.group8.Espy.model;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long>  {
}
