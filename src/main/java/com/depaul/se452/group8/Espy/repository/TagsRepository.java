package com.depaul.se452.group8.Espy.repository;

import com.depaul.se452.group8.Espy.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Long> {

}

