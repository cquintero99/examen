package co.com.example.examen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.example.examen.entities.Bill;
import co.com.example.examen.entities.User;
import co.com.example.examen.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserContoller {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/lista")
	public List<User>lista(){
		return userRepository.findAll();
	}
	
	@GetMapping("/{user}/bills")
	public List<Bill> listaMovimientos(@RequestBody String user ){
		Optional<User>userCurrent=userRepository.findByUsername(user);
		if(userCurrent.isPresent()) {
			return userCurrent.get().getMovimientos();
		}
		return null;
		
	}
	@GetMapping("/{user}/bills/{bill_id}")
	public Bill findById(@PathVariable String user, @PathVariable Integer bill_id) {
		Optional<User>userCurrent=userRepository.findByUsername(user);
		if(userCurrent.isPresent()) {
			BillController controller=new BillController();
			return controller.getById(bill_id);
		}
		return null;
	}
	
	

}
