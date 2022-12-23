package co.com.example.examen.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="bill")
public class Bill implements Serializable{
	@Id
	@SequenceGenerator(name="bill_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bill_id_seq")
	private Integer id;
	private Date date_bill;
	private Integer user_id;
	private Integer value;
	private Integer type;
	private String observation;

}
