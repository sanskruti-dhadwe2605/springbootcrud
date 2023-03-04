package seccom.example.demosecond.dao;


import org.springframework.data.repository.CrudRepository;

import seccom.example.demosecond.entities.*;

public interface UserRepository extends CrudRepository<User, Integer> {

}