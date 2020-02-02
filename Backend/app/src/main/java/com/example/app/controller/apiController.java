package com.example.app.controller;

import com.example.app.exception.UserNotFoundException;
import com.example.app.model.user;
import com.example.app.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class apiController {
    @Autowired
    userRepo userRepo;

    @GetMapping("/getAllUsers")
    public List<user> getAllUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/createUser")
    public user createUser(@Valid @RequestBody user user) {
        return userRepo.save(user);
    }

    @GetMapping("/getUserByID/{id}")
    public user getUserByID(@PathVariable(value = "id") Long id) throws UserNotFoundException {
        return userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/getUserByUserName/{username}")
    public user getUserByUserName(@PathVariable(value = "username") String username ) {
        return userRepo.findByUserName(username);
    }

    @GetMapping("/userExistByUserName/{username}")
    public user userExist(@PathVariable(value = "username") String username ) throws UserNotFoundException{
        if(userRepo.findByUserName(username).equals(userRepo)){
            throw new UserNotFoundException(username);
        }
        else{
            return userRepo.findByUserName(username);
        }

    }

    @GetMapping("/userExistById/{id}")
    public user userExist(@PathVariable(value = "id") Long id ) throws UserNotFoundException{
        return userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/updateUserById/{id}")
    public user updateUserName(@PathVariable(value = "id") Long id,
                               @Valid @RequestBody user userDetails) throws UserNotFoundException {

        user user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        user.setUserName(userDetails.getUserName());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());

        user updatedUser = userRepo.save(user);

        return updatedUser;
    }

    @PutMapping("/updateUserByUserName/{username}")
    public user updateUserByUserName(@PathVariable(value = "username") String username,
                                     @Valid @RequestBody user userDetails) {

        user user = userRepo.findByUserName(username);

        user.setUserName(userDetails.getUserName());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());

        user updatedUser = userRepo.save(user);

        return updatedUser;
    }


    @DeleteMapping("/deleteUserWithUserName/{username}")
    public ResponseEntity<?> deleteUserWithUserName(@PathVariable(value = "username") String username) {
        user user = userRepo.findByUserName(username);

        userRepo.delete(user);

        return ResponseEntity.ok("Deleted");
    }

    @DeleteMapping("/deleteUserWithUserId/{id}")
    public ResponseEntity<?> deleteUserWithUserId(@PathVariable(value = "id") Long id) throws UserNotFoundException {
        user user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        userRepo.delete(user);

        return ResponseEntity.ok("Deleted");
    }
}
