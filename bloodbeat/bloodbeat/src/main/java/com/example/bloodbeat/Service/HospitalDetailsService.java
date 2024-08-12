package com.example.bloodbeat.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bloodbeat.Modal.HospitalDetails;
import com.example.bloodbeat.Repository.HospitalDetailsRepository;

@Service
public class HospitalDetailsService {
	@Autowired
	private HospitalDetailsRepository hospitalDetailsRepository;

	public HospitalDetails saveHospital(HospitalDetails hospitalDetails) {
        return hospitalDetailsRepository.save(hospitalDetails);
	}

	public List<HospitalDetails> getAllHospitals() {
		return hospitalDetailsRepository.findAll();
	}

	public Optional<HospitalDetails> getHospitalById(Long id) {
		return hospitalDetailsRepository.findById(id);
	}

	public void deleteHospital(Long id) {
		hospitalDetailsRepository.deleteById(id);
	}

	public HospitalDetails updateHospitalDetails(HospitalDetails hospitalDetails) {
		 return hospitalDetailsRepository.save(hospitalDetails);
	}

}
