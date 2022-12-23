package co.com.example.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.examen.entities.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

}
