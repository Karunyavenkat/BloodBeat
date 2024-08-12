package com.example.bloodbeat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bloodbeat.Modal.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {
}
