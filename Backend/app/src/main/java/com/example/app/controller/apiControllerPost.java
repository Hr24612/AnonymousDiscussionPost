package com.example.app.controller;

import com.example.app.exception.ResourceNotFoundException;
import com.example.app.exception.UserNotFoundException;
import com.example.app.model.post;
import com.example.app.repo.postRepo;
import com.example.app.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 * API class for managing posts
 */
@RestController
@RequestMapping("/api/post")
public class apiControllerPost {

    //Reference to postRepo interface
    @Autowired
    postRepo postRepo;

    //Reference to postRepo interface
    @Autowired
     userRepo userRepo;

    //*****************//

    /*******************/
    /**** GET POSTS ****/
    /*******************/

    //Get all posts from
    @GetMapping("/getAllPosts")
    public List<post> getPosts(){
        return postRepo.findAll();
    }

    //Get all posts from specific user
    @GetMapping("/{userId}/posts")
    public List<post> getAllPosts(@PathVariable (value = "userId") Long userId){
        return postRepo.findByUserId(userId);
    }


    /*******************/
    /** END GET POSTS **/
    /*******************/

    //*****************//

    /*******************/
    /**** POST POSTS ***/
    /*******************/

    //Create a post as userId
    @PostMapping("/{userId}/createPost")
    public post createPost(@PathVariable (value = "userId") Long userId, @Valid @RequestBody post post) throws UserNotFoundException {
        return userRepo.findById(userId).map(user -> {
            post.setUser(user);
            return postRepo.save(post);
        }).orElseThrow(() -> new UserNotFoundException(userId));

    }

    /********************/
    /** END POST POSTS **/
    /********************/

    //*****************//

    /*******************/
    /**** PUT POSTS ****/
    /*******************/

    //Update post with userId
    @PutMapping("{userId}/updatePost/{postId}")
    public post updatePostById(@PathVariable (value="userId") Long userId,
                               @PathVariable (value = "postId") Long postId,
                               @Valid @RequestBody post post) throws UserNotFoundException {
        if(!userRepo.existsById(userId)){
            throw new UserNotFoundException(userId);
        }
        return postRepo.findById(postId).map(Post -> {
            Post.setBody(post.getBody());
            Post.setHashTag(post.getHashTag());
            return postRepo.save(Post);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }


    /********************/
    /** END PUT POSTS ***/
    /********************/

    //*****************//

    /*******************/
    /** DELETE POSTS ***/
    /*******************/

    //Delete post with userId
    @DeleteMapping("{userId}/deletePost/{postId}")
    public ResponseEntity<?> deletePostByUserId(@PathVariable (value = "userId") Long userId, @PathVariable (value = "postId") Long postId) throws UserNotFoundException {
        if(!userRepo.existsById(userId)){
            throw new UserNotFoundException(userId);
        }
        return postRepo.findById(postId).map(post -> {
            postRepo.delete(post);
            return ResponseEntity.ok().body("Deleted");
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }


    /**********************/
    /** END DELETE POSTS **/
    /**********************/

    //*****************//



}
