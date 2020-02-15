//package com.example.app.controller;
//
//import com.example.app.model.Post;
//import com.example.app.repo.postRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.web.bind.annotation.*;
//import org.springframework.http.ResponseEntity;
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/postApi")
//public class apiControllerPost {
//
//    @Autowired
//    postRepo postRepo;
//
//    //Tested with postman, ready for server
//    @PostMapping("/createPost")
//    public void addPost(@Valid @RequestBody Post post){
//        postRepo.save(post);
//    }
//
//    //TODO: Need to add functionality to receive post
//    //TODO: Test with post man
//    @GetMapping("/getPost")
//    public void getPost(){
//
//    }
//    //TODO: Add function to get all posts
//    //TODO: Test with post man
//    @GetMapping("/getAllPosts")
//    public List<Post> getAllPosts(){
//        List<Post> allPosts = postRepo.getAll();
//        return allPosts;
//    }
//
//    //TODO: Add function to get all posts by
//    //TODO: Test with post man
//    @GetMapping("/getPostsByHashtag")
//    public void getPostsByHashtag(@RequestParam("hashtag") String hashtag){
//        //Post allPosts = new Post("","","",hashtag,0,0);
//
//        //help
//        //for(Post cust: postRepo.findByHashtag(hashtag)){
//            //allPosts += cust.toPost();
//        //}
//    }
//
//    //will NOT be implemented by demo2
//    //TODO: Add function to get posts by new
//    //TODO: Test with post man
//    @GetMapping("/getPostByNew")
//    public void getPostByNew(){
//
//    }
//
//    //will NOT be implemented by demo2
//    //TODO: Add function to get posts by highest score
//    //TODO: Test with post man
//    @GetMapping("/getPostsByHighestScore")
//    public void getPostsByHighestScore(){
//
//    }
//
//    //TODO: Add function to delete a post
//    //TODO: Test with post man
//    @DeleteMapping("/deletePost")
//    public void deletePost(){
//
//    }
//
//    //TODO: Create a function to update a post (probably only going to let them update the body of the post?)
//    //TODO: Test with post man
//    @PutMapping("/updatePost")
//    public void updatePost(){
//
//    }
//
//}
