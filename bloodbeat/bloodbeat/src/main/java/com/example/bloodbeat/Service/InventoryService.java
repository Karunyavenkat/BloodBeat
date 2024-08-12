package com.example.bloodbeat.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bloodbeat.Modal.Inventory;
import com.example.bloodbeat.Repository.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
    private InventoryRepository repository;

	public List<Inventory> getAllBloodInventory() {
		return repository.findAll();
	}

	public Inventory getBloodInventoryById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Inventory saveBloodInventory(Inventory bloodInventory) {
		return repository.save(bloodInventory);
	}

	public String deleteBloodInventory(Long id) {
		repository.deleteById(id);
        return "Blood Inventory removed !! " + id;
	}

	public Inventory updateDonor(Inventory bloodInventory) {
		return repository.save(bloodInventory);
	}

	public int getTotalUnitsAvailable() {
		return repository.findTotalUnitsAvailable();
	}

	public Map<String, Integer> getUnitsPerBloodGroup() {
		List<Object[]> results = repository.findUnitsPerBloodGroup();
        Map<String, Integer> unitsPerBloodGroup = new HashMap<>();
        for (Object[] result : results) {
            unitsPerBloodGroup.put((String) result[0], (Integer) result[1]);
        }
        return unitsPerBloodGroup;
	}
}
