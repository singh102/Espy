package com.depaul.se452.group8.Espy.repository;

import java.util.UUID;

import com.depaul.se452.group8.Espy.model.DirectMessages;
import com.depaul.se452.group8.Espy.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tags, Long> {
}

