package seccom.example.demosecond.services;

import java.util.List;
//import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import seccom.example.demosecond.dao.UserRepository;
import seccom.example.demosecond.entities.User;

@Service
public class UserService {
   
  private UserRepository repo;
    public ResponseEntity<String> saveemployee(@RequestBody User user){
      try{
      repo.save(user);
      }
      catch(Exception e){
          return new ResponseEntity< >("not inserted",HttpStatus.INTERNAL_SERVER_ERROR);
      }
  return new ResponseEntity<String>("successfully inserted", HttpStatus.OK);
  }
}
