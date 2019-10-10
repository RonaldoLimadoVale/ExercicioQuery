package dev.fujioka.java.avancado.web.repository;

import dev.fujioka.java.avancado.web.domain.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository
     extends JpaRepository<Product, Long> {
	
	//public List<Product> findProductByName (String nome);
	
	@Query("select p from Product p where p.name = :name")
	public List<Product> buscarProduto(@Param("name") String nome);
	
	
	
	
	
}
