package com.example.app.controller;

import com.example.app.model.user;
import com.example.app.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class apiController {

    @Autowired
    userRepo repository;

    @RequestMapping("/save")
    public String process(){
        repository.save(new user("Jack", "Smith", "hr24612"));
        repository.save(new user("Adam", "Johnson", "apple1"));
        repository.save(new user("Kim", "Smith", "kill2"));
        repository.save(new user("David", "Williams", "22er"));
        repository.save(new user("Peter", "Davis","pd2"));
        return "Done";
    }

    @RequestMapping("/findall")
    public String findAll(){
        String result = "<html>";

        for(user cust : repository.findAll()){
            result += "<div>" + cust.toString() + "</div>";
        }

        return result + "</html>";
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = repository.findById(id).toString();
        return result;
    }

    @RequestMapping("/findbyusername")
    public String fetchDataByLastName(@RequestParam("username") String username){
        String result = "<html>";

        for(user cust: repository.findByUserName(username)){
            result += "<div>" + cust.toString() + "</div>";
        }

        return result + "</html>";
    }

    @RequestMapping("/deleteAll")
    public String deleteAll(){
        repository.deleteAll();
        return "All deleted";
    }


}
