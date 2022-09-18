package ma.project.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ma.project.client.entity.Client;
import ma.project.client.repository.IClientRepository;
import ma.project.client.service.Clientservices;
import ma.project.client.specification.SearchClient;

@Controller
public class ClientController {

	@Autowired
	private IClientRepository clientRepository;

	@Autowired
	private Clientservices clientservice;

	@GetMapping("/clients")
	public String search(Model model, SearchClient s, @RequestParam(name = "size", defaultValue = "0") int size) {

		// List Vide
		List<Client> listBy = new ArrayList<>();
	
		
	

			// Remplir List avec list client avec condition necessaire
			listBy = clientservice.search(s);
			
			for (Client c : listBy) {
				if (s.getSegment() != null
						&& (s.getSegment().equals("H1") || s.getSegment().equals("H2") || s.getSegment().equals("H3")
								|| s.getSegment().equals("H4") || s.getSegment().equals("H5") || s.getSegment().equals("H6")))

				{
		

            //update segement
				c.setSegment(s.getSegment());
				clientRepository.save(c);

			}

		}
		size = listBy.size();
		
		model.addAttribute("condition", s);
		model.addAttribute("listBy", listBy);
		model.addAttribute("size", size);

		return "clients";

	}
	
	

	
	
	
	
}
