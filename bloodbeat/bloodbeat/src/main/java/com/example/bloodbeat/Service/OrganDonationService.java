package com.example.bloodbeat.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bloodbeat.Modal.OrganDonation;
import com.example.bloodbeat.Repository.OrganDonationRepository;

@Service
public class OrganDonationService {
	@Autowired
	private OrganDonationRepository organDonationRepo;
	
	public List<OrganDonation> getAllOrgan() {
		return organDonationRepo.findAll();
	}

	public OrganDonation saveDonor(OrganDonation organDonation) {
		return organDonationRepo.save(organDonation);
	}

	public OrganDonation getOrganById(Long id) {
		return organDonationRepo.findById(id).orElse(null);
	}

	public OrganDonation updateOrgan(OrganDonation organDonation) {
		return organDonationRepo.save(organDonation);
	}

	public void deleteDonor(Long id) {
		organDonationRepo.deleteById(id);	
	}
}
