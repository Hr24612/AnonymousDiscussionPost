package com.example.anti_social.net_utils;

/**
 * Class used to store string constants for urls for use with volley requests
 */
public class Const {
    public static final String POSTMAN_URL = "https://postman-echo.com/get?foo1=bar1&foo2=bar2";
    public static final String LOCAL_HOST = "http://10.0.2.2";
    public static final String CREATEPOST = "http://coms-309-sk-4.cs.iastate.edu:8080/postApi/createPost";
    public static final String GETALLPOSTS = "http://coms-309-sk-4.cs.iastate.edu:8080/api/post/getAllPosts";

    public static String getUserByName(String name){
        return "http://coms-309-sk-4.cs.iastate.edu:8080/api/user/getUserByUserName/" + name;

    }
    public static String getPostUpvotes(int id){
        return "http://coms-309-sk-4.cs.iastate.edu:8080/api/post/"+id+"/likesByPostId";
    }
}
