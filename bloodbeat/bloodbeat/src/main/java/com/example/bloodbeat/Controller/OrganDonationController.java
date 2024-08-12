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

import com.example.bloodbeat.Modal.OrganDonation;
import com.example.bloodbeat.Service.OrganDonationService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/organDonation")
public class OrganDonationController {
	@Autowired
	private OrganDonationService organDonationService;
	
	@PostMapping("/create")
    public ResponseEntity<OrganDonation> createDonor(@RequestBody OrganDonation organDonation) {
        try {
        	OrganDonation savedOrgan = organDonationService.saveDonor(organDonation);
            return ResponseEntity.ok(savedOrgan);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
	
	@GetMapping
    public List<OrganDonation> getAllOrgan() {
        return organDonationService.getAllOrgan();
    }

	@GetMapping("/{id}")
    public OrganDonation getDonorById(@PathVariable Long id) {
        return organDonationService.getOrganById(id);
    }

    @PutMapping("/{id}")
    public OrganDonation updateDonor(@RequestBody OrganDonation organDonation, @PathVariable Long id) {
    	organDonation.setId(id);
        return organDonationService.updateOrgan(organDonation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDonor(@PathVariable Long id) {
    	organDonationService.deleteDonor(id);
        return ResponseEntity.ok().build();
    }
}
