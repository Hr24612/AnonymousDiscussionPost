package com.example.app.repo;

import com.example.app.model.Post;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface postRepo extends CrudRepository<Post,Long> {
    //I have no idea how to actually declare what these do

    //List<Post>

    //TODO: Figure out how to implement find posts by a hashtag
    List<Post> findByHashtag(String hashtag);

    //TODO: Figure out how to implement sort posts by newest
   // List<Post> sortByNew();

    //TODO: Figure out how to implement sort posts by highest score
   // List<Post> sortByHighestScore();
}
