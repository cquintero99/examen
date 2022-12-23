package co.com.example.examen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.example.examen.entities.Bill;
import co.com.example.examen.entities.User;
import co.com.example.examen.repository.BillRepository;
import co.com.example.examen.repository.UserRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserContoller {
	@Autowired
	UserRepository userRepository;
	@Autowired
	BillRepository billRepository;
	
	@GetMapping("/lista")
	public List<User>lista(){
		return userRepository.findAll();
	}
	@GetMapping("/{user}/usuario")
	public Optional<User> buscarUser(@PathVariable String user) {
		Optional<User>userCurrent=userRepository.findByUsername(user);
		if(userCurrent.isPresent()) {
			return userCurrent;
		}
		return null;
	}
	
	@GetMapping("/{user}/bills")
	public List<Bill> listaMovimientos(@PathVariable String user ){
		
		Optional<User>userCurrent=userRepository.findByUsername(user);
		
		if(userCurrent.isPresent()) {
			return userCurrent.get().getMovimientos();
		}
		return null;
		
	}
	@GetMapping("/{user}/bills/{bill_id}")
	public Optional<Bill> findById(@PathVariable String user, @PathVariable Integer bill_id) {
		Optional<User>userCurrent=userRepository.findByUsername(user);
		if(userCurrent.isPresent()) {
			return billRepository.findById(bill_id);
			
		}
		return null;
	}
	
	@DeleteMapping("/{user}/bills/{bill_id}")
	public void deleteById(@PathVariable String user,@PathVariable Integer bill_id){
		Optional<User>userCurrent=userRepository.findByUsername(user);
		if(userCurrent.isPresent()) {
			 billRepository.deleteById(bill_id);
		}
	}
	
	@PostMapping("/{user}/bills")
	public Bill saveBill(@PathVariable String user, @RequestBody Bill bill) {
		Optional<User> userCurrrent=userRepository.findByUsername(user);
		if(userCurrrent.isPresent()) {
			billRepository.save(bill);
			return bill;
		}
		return null;
		
	}
	@GetMapping("/{user}/login/{pass}")
		
		public Boolean login(@PathVariable String user,@PathVariable String pass) {
			Optional<User>userCurrent=userRepository.findByUsername(user);
			if(userCurrent.isPresent()) {
				if(userCurrent.get().getPass().equals(pass)) {
					return true;
				}
			}
			return false;
		}
	
	
	
	

}
