//package com.example.app.model;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import java.io.Serializable;
//
///**
// * Class that represents a user
// */
//
//@Entity
//@Table(name = "user")
//@EntityListeners(AuditingEntityListener.class)
//public class user implements Serializable {
//
//    //DB column to save user id
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    //DB column to save user's firstName
//    @NotBlank
//    private String firstName;
//
//    //DB column to save user's lastName
//    @NotBlank
//    private String lastName;
//
//    //DB column to save user's userName
//    @NotBlank
//    private String userName;
//
//    //Constructor to initialize DB columns
//    public user(Long id, String firstName, String lastName, String userName) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.userName = userName;
//    }
//
//    //Empty constructor to help with GET requests
//    public user(){ }
//
//    //*****************//
//
//    /*************************/
//    /** Getters and Setters **/
//    /*************************/
//
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//    public String getFirstName() { return firstName; }
//    public void setFirstName(String firstName) { this.firstName = firstName; }
//    public String getLastName() { return lastName; }
//    public void setLastName(String lastName) { this.lastName = lastName; }
//    public String getUserName() { return userName; }
//    public void setUserName(String userName) { this.userName = userName; }
//
//    /*****************************/
//    /** END Getters and Setters **/
//    /*****************************/
//
//    //*****************//
//
//}
