package co.com.example.examen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.example.examen.entities.Bill;
import co.com.example.examen.repository.BillRepository;
@RestController
@RequestMapping("/bills")
public class BillController {
	@Autowired
	BillRepository billRepository;
	
	@GetMapping
	public List<Bill>lista(){
		return billRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Bill getById(@PathVariable Integer id) {
		Optional<Bill>bill=billRepository.findById(id);
		if(bill.isPresent()) {
			return bill.get();
		}
		return null;
	}
	
	@PostMapping 
	public Bill save(@RequestBody Bill bill) {
		billRepository.save(bill);
		return bill;
	}
	@DeleteMapping("/{id}")
	public Bill delete(@PathVariable Integer id) {
		Optional<Bill> bill=billRepository.findById(id);
		if(bill.isPresent()) {
			billRepository.deleteById(id);
			return bill.get();
		}
		return null;
	}

}
