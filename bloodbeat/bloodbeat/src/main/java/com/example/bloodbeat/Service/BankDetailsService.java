package com.example.bloodbeat.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bloodbeat.Modal.BankDetails;
import com.example.bloodbeat.Repository.BankDetailsRepository;

@Service
public class BankDetailsService {
	@Autowired
	private BankDetailsRepository bankDetailsRepository;

	public BankDetails saveBankDetails(BankDetails bankDetails) {
		return bankDetailsRepository.save(bankDetails);
	}

	public List<BankDetails> getAllBankDetails() {
		return bankDetailsRepository.findAll();
	}

	public BankDetails getBankDetailsById(Long id) {
		return bankDetailsRepository.findById(id).orElse(null);
	}

	public BankDetails updateDetailsService(BankDetails bankDetails) {
		return bankDetailsRepository.save(bankDetails);
	}

	public void deleteBloodRequest(Long id) {
		bankDetailsRepository.deleteById(id);
	}
}
