package com.example.bloodbeat.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.bloodbeat.Modal.Donor;
import com.example.bloodbeat.Service.DonorService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/donors")
public class DonorController {
    @Autowired
    private DonorService donorService;
    

    @PostMapping("/create")
    public ResponseEntity<Donor> createDonor(@RequestBody Donor donor) {
        try {
            Donor savedDonor = donorService.saveDonor(donor);
            return ResponseEntity.ok(savedDonor);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping
    public List<Donor> getAllDonors() {
        return donorService.getAllDonors();
    }
    
    @GetMapping("/{id}")
    public Donor getDonorById(@PathVariable Long id) {
        return donorService.getDonorById(id);
    }

    @PutMapping("/{id}")
    public Donor updateDonor(@RequestBody Donor donor, @PathVariable Long id) {
        donor.setId(id);
        return donorService.updateDonor(donor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDonor(@PathVariable Long id) {
        donorService.deleteDonor(id);
        return ResponseEntity.ok().build();
    }
}
