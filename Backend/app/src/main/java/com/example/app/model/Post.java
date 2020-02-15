//package com.example.app.model;
//
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import java.io.Serializable;
//
//@Entity
//@Table(name = "post")
//@EntityListeners(AuditingEntityListener.class)
//public class Post implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name="title")
//    @NotNull
//    private String title;
//
//    @Column(name="body")
//    @NotNull
//    private String body;
//
//    @Column(name="creator")
//    @NotNull
//    private String creator;
//
//    @Column(name="hashtag")
//    @NotNull
//    private String hashtag;
//
//    @Column(name="likes")
//    @NotNull
//    private int likes;
//
//    @Column(name="dislikes")
//    @NotNull
//    private int dislikes;
//
//    @Column(name="score")
//    @NotNull
//    private int score;
//
////    public Post(){
////
////    }
//
//    public Post(Long id, String title, String body, String creator, String hashtag, int likes, int dislikes) {
//        this.id = id;
//        this.title = title;
//        this.body = body;
//        this.creator = creator;
//        this.hashtag = hashtag;
//        this.likes = likes;
//        this.dislikes = dislikes;
//        this.score = likes - dislikes;
//    }
//
//    public Post(){
//
//    }
//
//}
