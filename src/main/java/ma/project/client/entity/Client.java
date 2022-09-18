package ma.project.client.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor@AllArgsConstructor@Data
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	
	private double montantImpaye;
	
	private int nbrImpaye;
	
	private String ville;
	
	private String segment;
	
	private String csp;
	
	private Sg sg;
	

}
