package com.depaul.se452.group8.Espy.repository;

import com.depaul.se452.group8.Espy.model.Requests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestsRepository extends JpaRepository<Requests, Integer> {

}

