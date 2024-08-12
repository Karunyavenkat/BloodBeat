package com.example.bloodbeat.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bloodbeat.Modal.HospitalDetails;
import com.example.bloodbeat.Service.HospitalDetailsService;

@RestController
@RequestMapping("/api/hospitaldetails")
public class HospitalDetailsController {
	@Autowired
    private HospitalDetailsService hospitalDetailsService;

    @PostMapping
    public HospitalDetails createHospital(@RequestBody HospitalDetails hospitalDetails) {
        return hospitalDetailsService.saveHospital(hospitalDetails);
    }

    @GetMapping
    public List<HospitalDetails> getAllHospitals() {
        return hospitalDetailsService.getAllHospitals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalDetails> getHospitalById(@PathVariable Long id) {
        return hospitalDetailsService.getHospitalById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public HospitalDetails updateBloodRequest(@RequestBody HospitalDetails hospitalDetails, @PathVariable Long id) {
    	hospitalDetails.setId(id);
        return hospitalDetailsService.updateHospitalDetails(hospitalDetails );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHospital(@PathVariable Long id) {
        hospitalDetailsService.deleteHospital(id);
        return ResponseEntity.ok().build();
    }
}
