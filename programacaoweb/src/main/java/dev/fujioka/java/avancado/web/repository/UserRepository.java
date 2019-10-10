package dev.fujioka.java.avancado.web.repository;


import dev.fujioka.java.avancado.web.domain.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {
	
	
	
	@Query("select n from User n where n.lastName = :name")
	public List<User> ultimoNome(@Param("name") String name);
	
	@Query("select n from User n where n.firstName = :name")
	public List<User> primeiroNome(@Param("name") String name);
	
	@Query("SELECT u FROM User u Where u.firstName like %:R%")
	public List<User> buscarUsuarioPorSubstringPrimeiroNome(String R);
	
	@Query("SELECT u FROM User u Where u.lastName like %:L%")
	public List<User> buscarUsuarioPorSubstringUltimoNome(String L);
	
	@Query("select n from User n where n.login = :name")
	public List<User> login(@Param("name") String name);
	
	@Query("select n from User n where n.password = :name")
	public List<User> senha(@Param("name") String name);
	
	@Query("select n from User n Order By n.login")
	public List<User> descre();
	
	@Query("select count(n.login) from User n where n.login = :login")
	public long contar(@Param("login") String login);
	
	@Query("select count(n.firstName) from User n where n.firstName = :Pnome")
	public long contarPrimeiroNome(@Param("Pnome") String Pnome);
	
	@Query("select count(n.lastName) from User n where n.lastName = :Unome")
	public long contarUltimoNome(@Param("Unome") String Unome);
	
	public List<User> findAllByOrderByIdAsc();
	
	public List<User> findAllByOrderByIdDesc();

}