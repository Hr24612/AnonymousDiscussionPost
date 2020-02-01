package com.example.app.repo;

import com.example.app.model.user;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface userRepo extends CrudRepository<user, Long> {
    List<user> findByUserName(String username);
}
