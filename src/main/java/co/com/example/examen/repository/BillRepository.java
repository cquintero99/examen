package co.com.example.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.examen.entities.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{

}
