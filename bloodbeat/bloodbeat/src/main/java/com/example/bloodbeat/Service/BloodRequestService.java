package com.example.bloodbeat.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bloodbeat.Modal.BloodRequest;
import com.example.bloodbeat.Repository.BloodRequestRepository;

@Service
public class BloodRequestService {
	@Autowired
	 private BloodRequestRepository bloodRequestRepository;

	public BloodRequest saveBloodRequest(BloodRequest bloodRequest) {
		return bloodRequestRepository.save(bloodRequest);
	}

	public List<BloodRequest> getAllBloodRequests() {
		return bloodRequestRepository.findAll();
	}

	public BloodRequest getBloodRequestById(Long id) {
		return bloodRequestRepository.findById(id).orElse(null);
	}

	public BloodRequest updateBloodRequest(BloodRequest bloodRequest) {
		return bloodRequestRepository.save(bloodRequest);
	}

	public void deleteBloodRequest(Long id) {
		bloodRequestRepository.deleteById(id);
	}

}
