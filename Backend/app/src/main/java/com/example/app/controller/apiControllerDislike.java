//package com.example.app.controller;
//import com.example.app.exception.ResourceNotFoundException;
//import com.example.app.exception.UserNotFoundException;
//import com.example.app.model.dislike;
//import com.example.app.repo.dislikeRepo;
//import com.example.app.repo.postRepo;
//import com.example.app.repo.userRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;
//import java.util.List;
//
///**
// * API class for managing dislikes on a post
// */
//
//@RestController
//@RequestMapping("/api/post")
//public class apiControllerDislike {
//
//    //Reference to postRepo interface
//    @Autowired
//    postRepo postRepo;
//
//    //Reference to userRepo interface
//    @Autowired
//    userRepo userRepo;
//
//    //Reference to dislikeRepo interface
//    @Autowired
//    dislikeRepo dislikeRepo;
//
//    //*****************//
//
//    /******************/
//    /** GET DISLIKES **/
//    /******************/
//
//    //Get dislikes for a post with postId
//    @GetMapping("/{postId}/dislikesByPostId")
//    public List<dislike> getAllDislikesByPostId(@PathVariable(value = "postId") Long postId) {
//        return dislikeRepo.findByPostId(postId);
//    }
//
//    //Get posts liked by a user with userId
//    @GetMapping("/{userId}/dislikesByUserId")
//    public List<dislike> getAllDislikesByUserId(@PathVariable (value = "userId") Long userId) {
//        return dislikeRepo.findByUserId(userId);
//    }
//
//    //Get dislikeId
//    @GetMapping("/{userId}/{postId}/getDislikeId")
//    public Long getDislikeId(@PathVariable (value = "userId") Long userId, @PathVariable (value = "postId") Long postId) {
//        if(dislikeRepo.findByUserId(userId) != null && dislikeRepo.findByPostId(postId) != null){
//            return dislikeRepo.findByUserId(userId).get(0).getId();
//        }
//        else{
//             throw new ResourceNotFoundException("userId: " + userId + " or " + " postId: " + postId + " were incorrect");
//        }
//    }
//
//    /**********************/
//    /** END GET DISLIKES **/
//    /**********************/
//
//    //*****************//
//
//    /********************/
//    /** DISLIKES POSTS**/
//    /******************/
//
//    //Dislike a post with userId and postId
//    @PostMapping("/{userId}/{postId}/dislikePost")
//    public dislike dislikePost(@PathVariable (value = "userId") Long userId,
//                                 @PathVariable (value = "postId") Long postId,
//                                 @Valid dislike dislike) throws UserNotFoundException {
//        if(!userRepo.existsById(userId)){
//            throw new UserNotFoundException(userId);
//        }
//        else{
//            return postRepo.findById(postId).map(post -> {
//                dislike.setUser(userRepo.findByID(userId));
//                dislike.setPost(post);
//                return dislikeRepo.save(dislike);
//            }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
//        }
//    }
//
//    /************************/
//    /** END DISLIKES POSTS **/
//    /************************/
//
//    //***********************//
//
//    /************************/
//    /** UN-DISLIKES POSTS **/
//    /**********************/
//
//    //Un-dislike with userId and postId
//    @DeleteMapping("{userId}/{postId}/unDislike")
//    public ResponseEntity<?> unDislike(@PathVariable (value = "userId") Long userId,
//                                    @PathVariable (value = "postId") Long postId) throws UserNotFoundException {
//        if (dislikeRepo.findByUserId(userId) != null && dislikeRepo.findByPostId(postId) != null) {
//            dislikeRepo.delete(dislikeRepo.findByUserId(userId).get(0));
//            return new ResponseEntity<>("unDisliked!", HttpStatus.OK);
//        } else {
//            throw new ResourceNotFoundException("userId: " + userId + " or " + " postId: " + postId + " were incorrect");
//        }
//    }
//
//    /***************************/
//    /** END UN-DISLIKES POSTS **/
//    /***************************/
//
//    //***********************//
//}
