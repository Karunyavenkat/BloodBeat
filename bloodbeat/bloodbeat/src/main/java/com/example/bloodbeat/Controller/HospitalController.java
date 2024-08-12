package com.example.bloodbeat.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bloodbeat.Modal.Hospital;
import com.example.bloodbeat.Service.HospitalService;

@RestController
@RequestMapping("/api/hospitals")
@CrossOrigin(origins = "http://localhost:3000")
public class HospitalController {
	 @Autowired
	    private HospitalService hospitalService;

	    @GetMapping
	    public List<Hospital> getAllHospitals() {
	        return hospitalService.getAllHospitals();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Hospital> getHospitalById(@PathVariable Long id) {
	        Hospital hospital = hospitalService.getHospitalById(id);
	        if (hospital != null) {
	            return ResponseEntity.ok(hospital);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PostMapping("/create")
	    public ResponseEntity<Hospital> createHospital(@RequestBody Hospital hospital) {
	        Hospital createdHospital = hospitalService.saveHospital(hospital);
	        return ResponseEntity.ok(createdHospital);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<Hospital> updateHospital(@PathVariable Long id, @RequestBody Hospital hospitalDetails) {
	        Hospital hospital = hospitalService.getHospitalById(id);
	        if (hospital != null) {
	            hospital.setName(hospitalDetails.getName());
	            hospital.setLocation(hospitalDetails.getLocation());
	            hospital.setContact(hospitalDetails.getContact());
	            hospital.setEmail(hospitalDetails.getEmail());
	            Hospital updatedHospital = hospitalService.updateHospital(hospital);
	            return ResponseEntity.ok(updatedHospital);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteHospital(@PathVariable Long id) {
	        Hospital hospital = hospitalService.getHospitalById(id);
	        if (hospital != null) {
	            hospitalService.deleteHospital(id);
	            return ResponseEntity.ok().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
