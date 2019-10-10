package dev.fujioka.java.avancado.web.web.rest;

import dev.fujioka.java.avancado.web.domain.User;
import dev.fujioka.java.avancado.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.findAll();
    }
    
    @GetMapping("/busca/{name}")
    public List<User>  buscar(@PathVariable String name) {
        return userService.primeiroNome(name);
    }
    
    @GetMapping("/buscaLikeP/{R}")
    public List<User>  buscarLikeP(@PathVariable String R) {
        return userService.buscarLikeP(R);
    }
    
    @GetMapping("/buscaLikeU/{L}")
    public List<User>  buscarLikeU(@PathVariable String L) {
        return userService.buscarLikeU(L);
    }
    
  
    
    @GetMapping("/ordemAsc")
    public List<User> ordemAsc() {
        return userService.ordemAsc();
    }
    
    @GetMapping("/contar/{login}")
    public long contar(@PathVariable String login) {
        return userService.contar(login);
    }
    
    @GetMapping("/contarPnome/{Pnome}")
    public long contarPnome(@PathVariable String Pnome) {
    	return userService.contarPrimeiroNome(Pnome);
    }
    
    @GetMapping("/contarUnome/{Unome}")
    public long contarUnome(@PathVariable String Unome) {
    	return userService.contarUltimoNome(Unome);
    }
    
    @GetMapping("/ordemDesc")
    public List<User> ordemDesc() {
        return userService.ordemDesc();
    }
    
    @GetMapping("/Descre")
    public List<User> descre() {
        return userService.descre	();
    }
    
   

    @PostMapping("/user")
    public ResponseEntity<User>
    save(@Valid @RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok(user);
    }


    @PutMapping("/user")
    public ResponseEntity<User> update(@Valid @RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().body(user);
    }


    @DeleteMapping("/user")
    public ResponseEntity<String> delete(@Valid @RequestBody User user) {
        userService.delete(user);
       return  ResponseEntity.ok().body("User excluded ID: " + user.getId());
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().body("User excluded ID: " + id);
    }


}
