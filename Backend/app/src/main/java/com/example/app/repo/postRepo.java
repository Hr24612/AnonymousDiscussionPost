//package com.example.app.repo;
//
//import com.example.app.model.Post;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface postRepo extends JpaRepository<Post,Long> {
//    //I have no idea how to actually declare what these do
//
//    //List<Post>
//
//    @Query(value = "SELECT * FROM post", nativeQuery = true)
//    public List<Post> getAll();
//
//    //TODO: Figure out how to implement find posts by a hashtag
//    //List<Post> findByHashtag(String hashtag);
//
//    //TODO: Figure out how to implement sort posts by newest
//   // List<Post> sortByNew();
//
//    //TODO: Figure out how to implement sort posts by highest score
//   // List<Post> sortByHighestScore();
//}
