//package com.example.app.controller;
//import com.example.app.exception.ResourceNotFoundException;
//import com.example.app.exception.UserNotFoundException;
//import com.example.app.model.like;
//import com.example.app.repo.likeRepo;
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
// * API class for managing likes on a post
// */
//
//@RestController
//@RequestMapping("/api/post")
//public class apiControllerLike {
//
//    //Reference to postRepo interface
//    @Autowired
//    postRepo postRepo;
//
//    //Reference to userRepo interface
//    @Autowired
//    userRepo userRepo;
//
//    //Reference to likeRepo interface
//    @Autowired
//    likeRepo likeRepo;
//
//    //****************//
//
//    /****************/
//    /** GET LIKES ***/
//    /****************/
//
//    //Get likes for a post with postId
//    @GetMapping("/{postId}/likesByPostId")
//    public List<like> getAllLikesByPostId(@PathVariable(value = "postId") Long postId) {
//        return likeRepo.findByPostId(postId);
//    }
//
//    //Get posts liked by a user with userId
//    @GetMapping("/{userId}/likesByUserId")
//    public List<like> getAllLikesByUserId(@PathVariable (value = "userId") Long userId) {
//        return likeRepo.findByUserId(userId);
//    }
//
//    //Get likeId
//    @GetMapping("/{userId}/{postId}/getLikeId")
//    public Long getLikeId(@PathVariable (value = "userId") Long userId, @PathVariable (value = "postId") Long postId) {
//        if(likeRepo.findByUserId(userId) != null && likeRepo.findByPostId(postId) != null){
//            return likeRepo.findByUserId(userId).get(0).getId();
//        }
//        else{
//            throw new ResourceNotFoundException("userId: " + userId + " or " + " postId: " + postId + " were incorrect");
//        }
//    }
//
//    /********************/
//    /** END GET LIKES ***/
//    /********************/
//
//    //*****************//
//
//    /****************/
//    /** LIKE Post ***/
//    /****************/
//
//    //Like a post with userId and postId
//    @PostMapping("/{userId}/{postId}/likePost")
//    public like likePost(@PathVariable (value = "userId") Long userId,
//                               @PathVariable (value = "postId") Long postId,
//                               @Valid like like) throws UserNotFoundException {
//        if(!userRepo.existsById(userId)){
//            throw new UserNotFoundException(userId);
//        }
//        else{
//            return postRepo.findById(postId).map(post -> {
//                like.setUser(userRepo.findByID(userId));
//                like.setPost(post);
//                return likeRepo.save(like);
//            }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
//        }
//    }
//
//    /********************/
//    /** END LIKE POST ***/
//    /********************/
//
//    //*****************//
//
//    /*****************/
//    /** UNLIKE Post **/
//    /****************/
//
//    //Unlike with userId and postId
//    @DeleteMapping("{userId}/{postId}/unLike")
//    public ResponseEntity<?> unLike(@PathVariable (value = "userId") Long userId,
//                                       @PathVariable (value = "postId") Long postId) throws UserNotFoundException {
//        if(likeRepo.findByUserId(userId) != null && likeRepo.findByPostId(postId) != null){
//             likeRepo.delete(likeRepo.findByUserId(userId).get(0));
//            return new ResponseEntity<>("unLiked!", HttpStatus.OK);
//        }
//        else{
//            throw new ResourceNotFoundException("userId: " + userId + " or " + " postId: " + postId + " were incorrect");
//        }
//    }
//
//    /***********************/
//    /** END UNLIKE POST ****/
//    /***********************/
//
//    //**********************//
//
//}
