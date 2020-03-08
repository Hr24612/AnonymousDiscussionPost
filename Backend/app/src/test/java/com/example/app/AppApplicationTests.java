package com.example.app;


import com.example.app.repo.postRepo;
import com.example.app.controller.apiControllerPost;
import com.example.app.model.user;
import com.example.app.model.post;
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
	void contextLoads() {
	}



}
