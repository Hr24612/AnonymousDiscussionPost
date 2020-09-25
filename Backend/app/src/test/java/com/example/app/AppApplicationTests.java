package com.example.app;


import com.example.app.controller.apiControllerUser;
import com.example.app.model.*;
import com.example.app.repo.*;
import com.example.app.controller.apiControllerPost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;


/*NOTE: Run tests on local DB for best results.
Also, comment out WebSocketConfig.java and WebSocketServer.java,
these fail to work on local db.
 */
@SpringBootTest
class AppApplicationTests {


    @InjectMocks
    private apiControllerPost post;

    @MockBean
    private postRepo repo;

    @MockBean
    private userRepo userRepo;

    @InjectMocks
    private apiControllerUser apiControllerUser;

//	@Test
//	public void getPostsTest(){
//		int id1= 1;
//		int id2= 2;
//		Long id1long = Long.valueOf(id1);
//		Long id2long = Long.valueOf(id2);
//		user testUser = new user(id1long, "test", "test", "test", "test");
//
//		List<post> list = new ArrayList<post>();
//		post postOne = new post(id1long,"test","test","test",testUser);
//		post postTwo = new post(id2long,"test","test","test",testUser);
//
//		list.add(postOne);
//		list.add(postTwo);
//
//		when(repo.findAll()).thenReturn(list);
//
//		//List<post> postList = apiControllerPost.getPosts();
//		assertEquals(2, list.size());
//		//verify(repo,times(1).getAllPosts());
//
//	}
//
//	@Test
//	public void getAllPostsTest(){
//		int id1 = 1;
//		int id2 = 2;
//		Long id1long = Long.valueOf(id1);
//		Long id2long = Long.valueOf(id2);
//		user testUser = new user(id1long, "test", "test", "test", "test");
//
//		List<post> list = new ArrayList<post>();
//		post postOne = new post(id1long,"test","test","test",testUser);
//		post postTwo = new post(id2long,"test","test","test",testUser);
//
//		list.add(postOne);
//		list.add(postTwo);
//
//		when(repo.findByUserId(id1long)).thenReturn(list);
//
//		assertEquals(2,list.size());
//
//	}
//
//	@Test
//	public void createPostTest(){
//		int id1 = 1;
//		int id2 = 2;
//		Long id1long = Long.valueOf(id1);
//		Long id2long = Long.valueOf(id2);
//		user testUser = new user(id1long, "test", "test", "test", "test");
//
//		List<post> list = new ArrayList<post>();
//
//		post testPost = new post(id1long, "test", "test","test",testUser);
//
//		list.add(testPost);
//
//		when(repo.findByUserId(id1long)).thenReturn(list);
//
//		assertEquals(1, list.size());
//	}
//
//	//amir
//	@Test
//	public void getUsersTest(){
//		int id1= 1;
//		int id2= 2;
//		Long id1long = Long.valueOf(id1);
//		Long id2long = Long.valueOf(id2);
//		user testUser1 = new user(id1long, "test1", "test1", "test1", "test");
//		user testUser2 = new user(id2long, "test2", "test2", "test2", "test");
//		List<user> list = new ArrayList<user>();
//
//		list.add(testUser1);
//		list.add(testUser2);
//
//		when(userRepo.findAll()).thenReturn(list);
//
//		assertEquals(2, list.size());
//	}
//
//	//amir
//	@Test
//	public void getUserByLastName(){
//		int id1= 1;
//		int id2= 2;
//		Long id1long = Long.valueOf(id1);
//		Long id2long = Long.valueOf(id2);
//		user testUser1 = new user((long) 1,"test1", "test11", "test111", "test");
//		user testUser2 = new user((long) 2,"test2", "test22", "test222", "testt");
//		List<user> list = new ArrayList<user>();
//		list.add(testUser1);
//		list.add(testUser2);
//
//		assertEquals("test11", list.get(0).getLastName());
//		assertEquals(2, list.size());
//	}
//	@Test
//	void contextLoads() {
//	}
//
//    @InjectMocks
//    private apiControllerPost post;
//
//    @MockBean
//    private postRepo repo;
//
//    @MockBean
//    private userRepo userRepo;
//
//    @MockBean
//    private commentRepo commentRepo;
//
//    @MockBean
//    private likeRepo likeRepo;
//
//    @MockBean
//    private dislikeRepo dislikeRepo;
//
//    @InjectMocks
//    private apiControllerUser apiControllerUser;
//
//    @Test
//    public void getPostsTest(){
//		int id1= 1;
//        int id2= 2;
//        Long id1long = Long.valueOf(id1);
//        Long id2long = Long.valueOf(id2);
//        user testUser = new user(id1long,"test", "test", "test", "test");
//
//        List<post> list = new ArrayList<post>();
//        post postOne = new post(id1long,"test","test","test",testUser);
//        post postTwo = new post(id2long,"test","test","test",testUser);
//
//        list.add(postOne);
//        list.add(postTwo);
//
//        when(repo.findAll()).thenReturn(list);
//
//        assertEquals(2, list.size());
//
//    }
//
//    @Test
//    public void getAllPostsTest(){
//        int id1 = 1;
//        int id2 = 2;
//        Long id1long = Long.valueOf(id1);
//        Long id2long = Long.valueOf(id2);
//        user testUser = new user(id1long, "test","test", "test", "test");
//
//        List<post> list = new ArrayList<post>();
//        post postOne = new post(id1long,"test","test","test",testUser);
//        post postTwo = new post(id2long,"test","test","test",testUser);
//
//        list.add(postOne);
//        list.add(postTwo);
//
//        when(repo.findByUserId(id1long)).thenReturn(list);
//
//        assertEquals(2,list.size());
//
//    }
//
//    @Test
//    public void createPostTest(){
//        int id1 = 1;
//        int id2 = 2;
//        Long id1long = Long.valueOf(id1);
//        Long id2long = Long.valueOf(id2);
//        user testUser = new user(id1long, "test","test", "test", "test");
//
//        List<post> list = new ArrayList<post>();
//
//        post testPost = new post(id1long, "test", "test","test",testUser);
//
//        list.add(testPost);
//
//        when(repo.findByUserId(id1long)).thenReturn(list);
//
//        assertEquals(1, list.size());
//    }
//
//    //amir
//    @Test
//    public void getUsersTest(){
//        int id1= 1;
//        int id2= 2;
//        Long id1long = Long.valueOf(id1);
//        Long id2long = Long.valueOf(id2);
//        user testUser1 = new user(id1long, "test1","test1", "test1", "test1");
//        user testUser2 = new user(id2long, "test2","test2", "test2", "test2");
//        List<user> list = new ArrayList<user>();
//
//        list.add(testUser1);
//        list.add(testUser2);
//
//        when(userRepo.findAll()).thenReturn(list);
//
//        assertEquals(2, list.size());
//    }
//
//    //amir
//    @Test
//    public void getUserByLastName(){
//        int id1= 1;
//        int id2= 2;
//        Long id1long = Long.valueOf(id1);
//        Long id2long = Long.valueOf(id2);
//        user testUser1 = new user((long) 1,"test1","test1", "test11", "test111");
//        user testUser2 = new user((long) 2,"test2","test2", "test22", "test222");
//        List<user> list = new ArrayList<user>();
//        list.add(testUser1);
//        list.add(testUser2);
//
//        assertEquals("test1", list.get(0).getLastName());
//        assertEquals(2, list.size());
//    }
//    @Test
//    void contextLoads() {
//    }
//
//    //nick
//    @Test
//    public void getCommentsTest(){
//        int id1= 1;
//        int id2= 2;
//        Long id1long = Long.valueOf(id1);
//        Long id2long = Long.valueOf(id2);
//        user testUser = new user(id1long,"test", "test", "test", "test");
//        post testPost = new post(id2long,"test","test","test",testUser);
//        List<comment> list = new ArrayList<comment>();
//        comment commentOne = new comment(id1long,"test",testPost,testUser);
//        comment commentTwo = new comment(id2long,"test",testPost,testUser);
//        list.add(commentOne);
//        list.add(commentTwo);
//        when(commentRepo.findAll()).thenReturn(list);
//        assertEquals(2, list.size());
//    }
//    //nick
//    @Test
//    public void getLikesTest(){
//        int id1= 1;
//        int id2= 2;
//        Long id1long = Long.valueOf(id1);
//        Long id2long = Long.valueOf(id2);
//        user testUser = new user(id1long,"test", "test", "test", "test");
//        post testPost = new post(id2long,"test","test","test",testUser);
//        List<like> list = new ArrayList<like>();
//        like likeOne = new like(testUser,testPost,id1long);
//        like likeTwo = new like(testUser,testPost,id2long);
//        list.add(likeOne);
//        list.add(likeTwo);
//        when(likeRepo.findAll()).thenReturn(list);
//        assertEquals(2, list.size());
//    }
//
//    //nick
//    @Test
//    public void getDisLikesTest(){
//        int id1= 1;
//        int id2= 2;
//        Long id1long = Long.valueOf(id1);
//        Long id2long = Long.valueOf(id2);
//        user testUser = new user(id1long,"test", "test", "test", "test");
//        post testPost = new post(id2long,"test","test","test",testUser);
//        List<dislike> list = new ArrayList<dislike>();
//        dislike dislikeOne = new dislike(testUser,testPost,id1long);
//        dislike dislikeTwo = new dislike(testUser,testPost,id2long);
//        list.add(dislikeOne);
//        list.add(dislikeTwo);
//        when(dislikeRepo.findAll()).thenReturn(list);
//        assertEquals(2, list.size());
//    }

//    //Amir
//    @Test
//    public void dislikeTest(){
//        int id1= 1;
//        int id2= 2;
//        Long id1long = Long.valueOf(id1);
//        Long id2long = Long.valueOf(id2);
//        user testUser = new user(id1long,"test1", "test2", "test", "test");
//        post testPost = new post(id2long,"test","test","test",testUser);
//        List<dislike> list = new ArrayList<dislike>();
//        dislike dislikeOne = new dislike(testUser,testPost,id1long);
//        dislike dislikeTwo = new dislike(testUser,testPost,id2long);
//        list.add(dislikeOne);
//        list.add(dislikeTwo);
//        assertEquals("test1", list.get(0).getUser().getFirstName());
//        assertEquals("test2", list.get(0).getUser().getLastName());
//        assertEquals("test1", list.get(0).getPost().getUser().getFirstName());
//        assertEquals("test1", list.get(0).getPost().getUser().getLastName());
//    }

    //Amir
//    @Test
//    public void dislikeTest(){
//        int id1= 1;
//        int id2= 2;
//        Long id1long = Long.valueOf(id1);
//        Long id2long = Long.valueOf(id2);
//        user testUser = new user(id1long,"test1", "test2", "test", "test");
//        post testPost = new post(id2long,"test","test","test",testUser);
//        List<dislike> list = new ArrayList<dislike>();
//        dislike dislikeOne = new dislike(testUser,testPost,id1long);
//        dislike dislikeTwo = new dislike(testUser,testPost,id2long);
//        list.add(dislikeOne);
//        list.add(dislikeTwo);
//        assertEquals("test1", list.get(0).getUser().getFirstName());
//        assertEquals("test2", list.get(0).getUser().getLastName());
//        assertEquals("test1", list.get(0).getPost().getUser().getFirstName());
//        assertEquals("test1", list.get(0).getPost().getUser().getLastName());
//    }
}
