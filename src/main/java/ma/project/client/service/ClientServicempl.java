package ma.project.client.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.client.entity.Client;
import ma.project.client.repository.IClientRepository;
import ma.project.client.specification.ClientSpecification;
import ma.project.client.specification.SearchClient;

@Service
@Transactional
public class ClientServicempl implements Clientservices{
	
	@Autowired
	private IClientRepository clientRepository;



	// Method find by Clientservices and return list client 
	
	@Override
	public List<Client> search(SearchClient searchClient) {
			
		ClientSpecification cLientSpec = new ClientSpecification(searchClient);
				
				 return clientRepository.findAll(cLientSpec);
				
	}





	
	
	
	

}
