package com.example.bloodbeat.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bloodbeat.Modal.Hospital;
import com.example.bloodbeat.Repository.HospitalRepository;

@Service
public class HospitalService {
	@Autowired
    private HospitalRepository hospitalRepository;

	public List<Hospital> getAllHospitals() {
		return hospitalRepository.findAll();
	}

	public Hospital getHospitalById(Long id) {
		Optional<Hospital> hospital = hospitalRepository.findById(id);
        return hospital.orElse(null);
	}

	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	public Hospital updateHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	public void deleteHospital(Long id) {
		hospitalRepository.deleteById(id);
		
	}

}
