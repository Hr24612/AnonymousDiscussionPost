package com.example.app.repo;

import com.example.app.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface userRepo extends JpaRepository<user, Long> {
    @Query("select c from user c where c.userName = :userName")
    public user findByUserName(@Param("userName")String username);
}
