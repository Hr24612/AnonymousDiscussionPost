package com.example.anti_social.comparators;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CompareTest {
    @Test
    public void testCompare() throws JSONException {
        JSONObject one = mock(JSONObject.class);
        JSONObject two = mock(JSONObject.class);
        JSONObjectDateCompare test = new JSONObjectDateCompare();
        when(one.getInt("updatedAt")).thenReturn(1);
        when(two.getInt("updatedAt")).thenReturn(2);
        assertEquals(-1, test.compare(one, two));
    }
}