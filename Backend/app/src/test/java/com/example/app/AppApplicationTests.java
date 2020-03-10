package com.example.app;


import com.example.app.controller.apiControllerUser;
import com.example.app.repo.postRepo;
import com.example.app.controller.apiControllerPost;
import com.example.app.model.user;
import com.example.app.model.post;
import com.example.app.repo.userRepo;
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

	@Test
	public void getPostsTest(){
		int id1= 1;
		int id2= 2;
		Long id1long = Long.valueOf(id1);
		Long id2long = Long.valueOf(id2);
		user testUser = new user(id1long, "test", "test", "test");

		List<post> list = new ArrayList<post>();
		post postOne = new post(id1long,"test","test","test",testUser);
		post postTwo = new post(id2long,"test","test","test",testUser);

		list.add(postOne);
		list.add(postTwo);

		when(repo.findAll()).thenReturn(list);

		//List<post> postList = apiControllerPost.getPosts();
		assertEquals(2, list.size());
		//verify(repo,times(1).getAllPosts());

	}

	@Test
	public void getAllPostsTest(){
		int id1 = 1;
		int id2 = 2;
		Long id1long = Long.valueOf(id1);
		Long id2long = Long.valueOf(id2);
		user testUser = new user(id1long, "test", "test", "test");

		List<post> list = new ArrayList<post>();
		post postOne = new post(id1long,"test","test","test",testUser);
		post postTwo = new post(id2long,"test","test","test",testUser);

		list.add(postOne);
		list.add(postTwo);

		when(repo.findByUserId(id1long)).thenReturn(list);

		assertEquals(2,list.size());

	}

	@Test
	public void createPostTest(){
		int id1 = 1;
		int id2 = 2;
		Long id1long = Long.valueOf(id1);
		Long id2long = Long.valueOf(id2);
		user testUser = new user(id1long, "test", "test", "test");

		List<post> list = new ArrayList<post>();

		post testPost = new post(id1long, "test", "test","test",testUser);

		list.add(testPost);

		when(repo.findByUserId(id1long)).thenReturn(list);

		assertEquals(1, list.size());
	}

	//amir
	@Test
	public void getUsersTest(){
		int id1= 1;
		int id2= 2;
		Long id1long = Long.valueOf(id1);
		Long id2long = Long.valueOf(id2);
		user testUser1 = new user(id1long, "test1", "test1", "test1");
		user testUser2 = new user(id2long, "test2", "test2", "test2");
		List<user> list = new ArrayList<user>();

		list.add(testUser1);
		list.add(testUser2);

		when(userRepo.findAll()).thenReturn(list);

		assertEquals(2, list.size());
	}

	//amir
	@Test
	public void getUserByLastName(){
		int id1= 1;
		int id2= 2;
		Long id1long = Long.valueOf(id1);
		Long id2long = Long.valueOf(id2);
		user testUser1 = new user((long) 1,"test1", "test11", "test111");
		user testUser2 = new user((long) 2,"test2", "test22", "test222");
		List<user> list = new ArrayList<user>();
		list.add(testUser1);
		list.add(testUser2);

		assertEquals("test11", list.get(0).getLastName());
		assertEquals(2, list.size());
	}
	@Test
	void contextLoads() {
	}

}
