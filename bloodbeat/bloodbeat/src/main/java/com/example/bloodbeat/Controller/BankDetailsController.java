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

import com.example.bloodbeat.Modal.BankDetails;
import com.example.bloodbeat.Service.BankDetailsService;

@RestController
@RequestMapping("/api/bloodbankdetails")
public class BankDetailsController {
	@Autowired
	private BankDetailsService bankDetailsService;
	
	@PostMapping
    public BankDetails createBloodRequest(@RequestBody BankDetails bankDetails) {
        return bankDetailsService.saveBankDetails(bankDetails);
    }

    @GetMapping
    public List<BankDetails> getAllBankDetails() {
        return bankDetailsService.getAllBankDetails();
    }

    @GetMapping("/{id}")
    public BankDetails getBankDetailsById(@PathVariable Long id) {
        return bankDetailsService.getBankDetailsById(id);
    }

    @PutMapping("/{id}")
    public BankDetails updateBloodRequest(@RequestBody BankDetails bankDetails, @PathVariable Long id) {
    	bankDetails.setId(id);
        return bankDetailsService.updateDetailsService(bankDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBloodRequest(@PathVariable Long id) {
    	bankDetailsService.deleteBloodRequest(id);
        return ResponseEntity.ok().build();
    }
	
}
