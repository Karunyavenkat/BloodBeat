package com.example.bloodbeat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bloodbeat.Modal.OrganDonation;

@Repository
public interface OrganDonationRepository extends JpaRepository<OrganDonation, Long>{

}
