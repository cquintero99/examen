package co.com.example.examen.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.examen.entities.User;

public interface UserRepository  extends JpaRepository<User, Integer>{
	public Optional<User> findByUsername(String username);

}
