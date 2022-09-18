package ma.project.client.service;

import java.util.List;

import ma.project.client.entity.Client;
import ma.project.client.specification.SearchClient;

public interface Clientservices  {
	
	
	List<Client> search(SearchClient searchClient  );
	
	
	

	

}
