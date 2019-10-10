package dev.fujioka.java.avancado.web.service;


import dev.fujioka.java.avancado.web.domain.User;
import dev.fujioka.java.avancado.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements CrudInterface<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> save(User entity) {
        return Optional.of(userRepository.save(entity));
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public long count() {
        return userRepository.count();
    }
    
    
    public List<User> primeiroNome(String name) {
        return userRepository.primeiroNome(name);
    }
    
    
    public List<User> ordemAsc() {
        return userRepository.findAllByOrderByIdAsc();
    }
    
    public List<User> ordemDesc() {
        return userRepository.findAllByOrderByIdDesc();
    }
    
    public List<User> descre(){
    	return userRepository.descre();
    }
    
    public long contar(String login){
    	return userRepository.contar(login);
    }
    
    public long contarPrimeiroNome(String Pnome){
    	return userRepository.contarPrimeiroNome(Pnome);
    }
    
    public long contarUltimoNome(String Unome){
    	return userRepository.contarUltimoNome(Unome);
    }
    
    public List<User> buscarLikeP(String R){
    	return userRepository.buscarUsuarioPorSubstringPrimeiroNome(R);
    }
   
    public List<User> buscarLikeU(String L){
    	return userRepository.buscarUsuarioPorSubstringUltimoNome(L);
    }
   
}
