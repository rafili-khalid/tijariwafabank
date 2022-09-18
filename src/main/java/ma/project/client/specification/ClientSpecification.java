package ma.project.client.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.project.client.entity.Client;

@NoArgsConstructor
@AllArgsConstructor
public class ClientSpecification implements Specification<Client> {

	private static final long serialVersionUID = 1L;
	
	
	private SearchClient search;
	
	// methode for Specifaction condition 

	@Override
	public Predicate toPredicate(Root<Client> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		List<Predicate> conditions = new ArrayList<>();

		// MontantImpaye

		if (search.getMin() != 0.0 && search.getMax() != 0.0) {

			conditions.add(cb.between(root.get("montantImpaye"), search.getMin(), search.getMax()));
		}

		// villes

		if (search.getVilles() != null) {

			In<String> in = cb.in(root.get("ville"));

			for (String ville : search.getVilles()) {

				in = in.value(ville);

				conditions.add(in);
			}
		}

			// NbrImpaye

			if (search.getNbrImpaye() !=0) {

				conditions.add(cb.equal(root.get("nbrImpaye"), search.getNbrImpaye()));
			}

			// Csp

			if (search.getCsp() != null) {

				conditions.add(cb.like(root.get("csp"),"%"+ search.getCsp()+"%"));
			}
		
			
			// Sg

			if (search.getSg() != null) {
				
				conditions.add(cb.equal(root.get("sg"), search.getSg()));

			}
			
			
		return cb.and(conditions.toArray(new Predicate[0]));
	}

}
