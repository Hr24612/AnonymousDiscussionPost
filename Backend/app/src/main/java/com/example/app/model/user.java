package com.example.app.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class user implements Serializable {
    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "username")
    private String userName;

    protected user() {
    }

    public user(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;

    }

    @Override
    public String toString() {
        return String.format("[id=%d, firstName='%s', lastName='%s', userName='%s']", id, firstName, lastName, userName);
    }
}
