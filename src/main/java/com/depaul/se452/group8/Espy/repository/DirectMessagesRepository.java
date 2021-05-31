package com.depaul.se452.group8.Espy.repository;

import com.depaul.se452.group8.Espy.model.DirectMessages;
import com.depaul.se452.group8.Espy.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface DirectMessagesRepository extends JpaRepository<DirectMessages, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM direct_messages WHERE recipient_id = ?1 ORDER BY created_at DESC")
    List<DirectMessages> findByUserIds(Integer recipientId);
}

