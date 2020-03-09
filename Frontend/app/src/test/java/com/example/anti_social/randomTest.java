package com.example.anti_social;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class randomTest {

    @Mock
    JSONObject fakePost;

    @Mock
    postActivity p;

    @Test
    public void testLogin() throws JSONException {
        when(fakePost.getString("title")).thenReturn("Fake Title");
        when(fakePost.getString("body")).thenReturn("According to all known laws of aviation");
        when(fakePost.getString("hashTag")).thenReturn("stuff");
        p.fillPostContent(fakePost);
        assertEquals("Fake Title", p.getPostTitle());
        assertEquals("According to all known laws of aviation", p.getPostBody());
        assertEquals("stuff", p.getPostTag());
    }
}
