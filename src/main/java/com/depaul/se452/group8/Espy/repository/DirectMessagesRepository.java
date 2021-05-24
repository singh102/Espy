package com.depaul.se452.group8.Espy.repository;

import java.util.UUID;

import com.depaul.se452.group8.Espy.model.Comments;
import com.depaul.se452.group8.Espy.model.DirectMessages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectMessagesRepository extends JpaRepository<DirectMessages, Long>  {
}

