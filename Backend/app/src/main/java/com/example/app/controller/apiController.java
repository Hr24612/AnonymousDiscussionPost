//package com.example.app.controller;
//
//import com.example.app.exception.UserNotFoundException;
//import com.example.app.model.user;
//import com.example.app.repo.userRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class apiController {
//    @Autowired
//    userRepo userRepo;
//
//    //Tested in post man, working, ready for server
//    @GetMapping("/getAllUsers")
//    public List<user> getAllUsers() {
//        return userRepo.findAll();
//    }
//
//    //Tested in post man, working, ready for server
//    @PostMapping("/createUser")
//    public user createUser(@Valid @RequestBody user user) {
//        return userRepo.save(user);
//    }
//
//    //Tested in post man, working, ready for server
//    @GetMapping("/getUserByID/{id}")
//    public user getUserByID(@PathVariable(value = "id") Long id) throws UserNotFoundException {
//        return userRepo.findById(id)
//                .orElseThrow(() -> new UserNotFoundException(id));
//    }
//
//    //Tested in post man, working, ready for server
//    @GetMapping("/getUserByUserName/{username}")
//    public user getUserByUserName(@PathVariable(value = "username") String username ) {
//        return userRepo.findByUserName(username);
//    }
//
//    //Tested in post man, I think it's working? Not sure what it's supposed to do, if it's
//    //supposed to error out when a non-existant username is given then it is working just fine
//    @GetMapping("/userExistByUserName/{username}")
//    public user userExist(@PathVariable(value = "username") String username ) throws UserNotFoundException{
//        if(userRepo.findByUserName(username).equals(userRepo)){
//            throw new UserNotFoundException(username);
//        }
//        else{
//            return userRepo.findByUserName(username);
//        }
//
//    }
//    //Tested in post man, I think it's working? Not sure what it's supposed to do, if it's
//    //supposed to error out when a non-existant id is given then it is working just fine
//    @GetMapping("/userExistById/{id}")
//    public user userExist(@PathVariable(value = "id") Long id ) throws UserNotFoundException{
//        return userRepo.findById(id)
//                .orElseThrow(() -> new UserNotFoundException(id));
//    }
//    //Test in postman, working, ready for server
//    @PutMapping("/updateUserById/{id}")
//    public user updateUserName(@PathVariable(value = "id") Long id,
//                               @Valid @RequestBody user userDetails) throws UserNotFoundException {
//
//        user user = userRepo.findById(id)
//                .orElseThrow(() -> new UserNotFoundException(id));
//
//        user.setUserName(userDetails.getUserName());
//        user.setFirstName(userDetails.getFirstName());
//        user.setLastName(userDetails.getLastName());
//
//        user updatedUser = userRepo.save(user);
//
//        return updatedUser;
//    }
//
//    //Test in postman, working, ready for server
//    @PutMapping("/updateUserByUserName/{username}")
//    public user updateUserByUserName(@PathVariable(value = "username") String username,
//                                     @Valid @RequestBody user userDetails) {
//
//        user user = userRepo.findByUserName(username);
//
//        user.setUserName(userDetails.getUserName());
//        user.setFirstName(userDetails.getFirstName());
//        user.setLastName(userDetails.getLastName());
//
//        user updatedUser = userRepo.save(user);
//
//        return updatedUser;
//    }
//
//    //Test in postman, working, ready for server
//    @DeleteMapping("/deleteUserWithUserName/{username}")
//    public ResponseEntity<?> deleteUserWithUserName(@PathVariable(value = "username") String username) {
//        user user = userRepo.findByUserName(username);
//
//        userRepo.delete(user);
//
//        return ResponseEntity.ok("Deleted");
//    }
//    //Test in postman, working, ready for server
//    @DeleteMapping("/deleteUserWithUserId/{id}")
//    public ResponseEntity<?> deleteUserWithUserId(@PathVariable(value = "id") Long id) throws UserNotFoundException {
//        user user = userRepo.findById(id)
//                .orElseThrow(() -> new UserNotFoundException(id));
//
//        userRepo.delete(user);
//
//        return ResponseEntity.ok("Deleted");
//    }
//}
