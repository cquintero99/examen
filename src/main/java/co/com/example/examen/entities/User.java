package co.com.example.examen.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User implements Serializable  {
	@Id
	@SequenceGenerator(name="user_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_id_seq")
	private Integer id;
	private String username;
	private String pass;
	private String email;
	@JsonIgnore
	private List<Bill>movimientos;

}
