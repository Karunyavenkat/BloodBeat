package com.example.bloodbeat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bloodbeat.Modal.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>{

}
