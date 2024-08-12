package com.example.bloodbeat.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bloodbeat.Modal.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{

	@Query("SELECT SUM(b.quantityAvailable) FROM Inventory b")
	int findTotalUnitsAvailable();

	@Query("SELECT b.bloodGroup, SUM(b.quantityAvailable) FROM Inventory b GROUP BY b.bloodGroup")
	List<Object[]> findUnitsPerBloodGroup();

}
