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

import com.example.bloodbeat.Modal.BloodRequest;
import com.example.bloodbeat.Service.BloodRequestService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/requests")
public class BloodRequestController {
	 @Autowired
    private BloodRequestService bloodRequestService;

    @PostMapping("/create")
    public BloodRequest createBloodRequest(@RequestBody BloodRequest bloodRequest) {
        return bloodRequestService.saveBloodRequest(bloodRequest);
    }
    
    @GetMapping
    public List<BloodRequest> getAllBloodRequests() {
        return bloodRequestService.getAllBloodRequests();
    }

    @GetMapping("/{id}")
    public BloodRequest getBloodRequestById(@PathVariable Long id) {
        return bloodRequestService.getBloodRequestById(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<BloodRequest> updateBloodRequest(@RequestBody BloodRequest bloodRequest, @PathVariable Long id) {
        BloodRequest existingRequest = bloodRequestService.getBloodRequestById(id);
        if (existingRequest == null) {
            return ResponseEntity.notFound().build();
        }
        bloodRequest.setId(id); // Ensure the ID is set correctly
        BloodRequest updatedRequest = bloodRequestService.updateBloodRequest(bloodRequest);
        return ResponseEntity.ok(updatedRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBloodRequest(@PathVariable Long id) {
        bloodRequestService.deleteBloodRequest(id);
        return ResponseEntity.ok().build();
    }

}
