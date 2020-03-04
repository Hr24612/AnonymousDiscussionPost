//package com.example.app.repo;
//import com.example.app.model.like;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//
///**
// * Like repository interface that allows the API to communicate with the like table in the DB
// */
//
//@Repository
//public interface likeRepo extends JpaRepository<like,Long>{
//
//    //Find a list of dislikes for a user with userId
//    @Query(value = "SELECT * FROM likes d WHERE d.user_id = :id", nativeQuery = true)
//    List<like> findByUserId(@Param("id")Long userId);
//
//    //Find a list of dislikes for a post with postId
//    @Query(value = "SELECT * FROM likes c WHERE c.post_id = :id", nativeQuery = true)
//    List<like> findByPostId(@Param("id")Long postId);
//}
