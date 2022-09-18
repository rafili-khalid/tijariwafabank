package ma.project.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import ma.project.client.entity.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client,Long>, JpaSpecificationExecutor<Client>{
	
	
	

}
