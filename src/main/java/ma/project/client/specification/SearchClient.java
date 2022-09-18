package ma.project.client.specification;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import ma.project.client.entity.Sg;


//class attributes for make the conditions for research

@Data
public class SearchClient {

	private double min;
	private double max;
	private  int nbrImpaye;
	private String csp;
	private Sg sg;
	private String segment;
	private List<String> villes = new ArrayList<>();

}
