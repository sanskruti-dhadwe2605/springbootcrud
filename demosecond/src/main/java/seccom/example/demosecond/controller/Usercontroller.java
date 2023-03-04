package seccom.example.demosecond.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import seccom.example.demosecond.entities.*;
import seccom.example.demosecond.services.UserService;
import seccom.example.demosecond.dao.*;

@RestController
@RequestMapping("/users")
public class Usercontroller{
@Autowired
private UserRepository repo;
@Autowired
private UserService serimpl;

@PostMapping("/save")
public ResponseEntity<String> saveemployee(@RequestBody User user){
    try{
    repo.save(user);
    }
  
    catch(Exception e){
        return new ResponseEntity< >("not inserted",HttpStatus.INTERNAL_SERVER_ERROR);
    }
return new ResponseEntity<String>("successfully inserted", HttpStatus.OK);
}
@GetMapping("/getAll")
private List<User> getAll(){
    
    return (List<User>) repo.findAll();
}

@DeleteMapping("/deletebyid/{id}")
private String deletebyid(@PathVariable("id") int id){
    String msg;
    try{
       repo.deleteById(id);
       msg="Imformation Deleted successfully";

    }catch(Exception e){
        msg="We can't fullfil your request";

    }
    return msg;
}
@PutMapping("/updatebyid/{id}")
private User updatebyid(@PathVariable("id") int id, @RequestBody User user ){
    Optional<User> temp=repo.findById(id);
    User u=temp.get();

    
    u.setAge(user.getAge());
    u.setName(user.getName());
    u.setMobileNSo(user.getMobileNSo());
    // repo.delete(u);
    repo.save(u);


        
    return u;
    }
   

@GetMapping("/searchmapping/{id}")
private Optional<User> searchbyid(@PathVariable("id") int id,@RequestBody User user){
    return repo.findById(id);
}

}