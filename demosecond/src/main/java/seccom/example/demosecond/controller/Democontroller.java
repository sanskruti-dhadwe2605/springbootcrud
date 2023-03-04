package seccom.example.demosecond.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seccom.example.demosecond.model.*;
import java.util.List;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/employee")
public class Democontroller {
    
    List<employee> emplist=new ArrayList<employee>();


    @GetMapping(value = "/getdemo")
    public String getDemo(){
        return "hello";

    } 
    @PostMapping(value = "/getdemo/{num1}/{num2}")
    public int getDemo(@PathVariable(value="num1") int num1, @PathVariable(value="num2") int num2){
        return num1+num2;

    } 
    @PostMapping("/save")
    public employee saveemployee(@RequestBody employee employee ) {
        emplist.add(employee);
        return employee; 
    }
    @GetMapping(value="/getAll")
    public List<employee> getAllEmployee() {
        return emplist;
    }
    
    @GetMapping("getbyid/{id}")
        public employee getempId(@PathVariable int id){
            employee temp=null;
            for(employee employee:emplist){
                if(id==employee.getId()){
                 temp=employee;
                 break;
                }
            }
            return temp;
        } 
        @DeleteMapping("deletebyid/{id}")
        public String getdelete(@PathVariable int id){
            employee temp=null;
            for(employee employee:emplist){
                if(id==employee.getId()){
                 emplist.remove(temp);
                 break;
                }
            }
            return "Your information is deleted successfully";
        } 
        
        @PutMapping("/updatebyid/{id}")
        public employee updatebyid(@PathVariable int id,@RequestBody String name){
            employee temp=null;
            for(employee employee:emplist){
                if(id==employee.getId()){
                employee.setName(name);
                temp=employee;
                 break;
                }
            }
           

            return temp;
        }

    
    }

   

