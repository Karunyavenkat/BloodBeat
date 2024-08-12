package com.example.bloodbeat.Controller;

import java.util.List;
import java.util.Map;

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

import com.example.bloodbeat.Modal.Inventory;
import com.example.bloodbeat.Service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(origins = "http://localhost:3000")
public class InventoryController {
	@Autowired
    private InventoryService service;

    @GetMapping
    public List<Inventory> findAllBloodInventory() {
        return service.getAllBloodInventory();
    }

    @GetMapping("/{id}")
    public Inventory findBloodInventoryById(@PathVariable Long id) {
        return service.getBloodInventoryById(id);
    }

    @PostMapping()
    public Inventory addBloodInventory(@RequestBody Inventory bloodInventory) {
        return service.saveBloodInventory(bloodInventory);
    }

    @PutMapping("/{id}")
    public Inventory updateBloodInventory(@RequestBody Inventory bloodInventory, @PathVariable Long id) {
    	bloodInventory.setId(id);
        return service.updateDonor(bloodInventory);
    }

    @DeleteMapping("/{id}")
    public String deleteBloodInventory(@PathVariable Long id) {
        return service.deleteBloodInventory(id);
    }
    
    @GetMapping("/total-units")
    public ResponseEntity<Integer> getTotalUnitsAvailable() {
        int totalUnits = service.getTotalUnitsAvailable();
        return ResponseEntity.ok(totalUnits);
    }

    @GetMapping("/units-per-blood-group")
    public ResponseEntity<Map<String, Integer>> getUnitsPerBloodGroup() {
        Map<String, Integer> unitsPerBloodGroup = service.getUnitsPerBloodGroup();
        return ResponseEntity.ok(unitsPerBloodGroup);
    }
}
