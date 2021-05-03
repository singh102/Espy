package com.depaul.se452.group8.Espy.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.depaul.se452.group8.Espy.model.Requests;

public interface RequestsRepository extends JpaRepository<Requests, Integer>{
}

