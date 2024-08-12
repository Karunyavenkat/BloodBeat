package com.example.bloodbeat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bloodbeat.Modal.BloodRequest;

@Repository
public interface BloodRequestRepository extends JpaRepository<BloodRequest, Long>{

}
