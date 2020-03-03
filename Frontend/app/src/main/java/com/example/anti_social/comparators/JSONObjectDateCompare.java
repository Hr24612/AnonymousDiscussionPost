package com.example.anti_social.comparators;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Comparator;

/**
 * A class to be used to help sort the array of posts served to the end user.
 */
public class JSONObjectDateCompare implements Comparator<JSONObject> {
    @Override
    public int compare(JSONObject first, JSONObject second){
        int firstDate = 0, secondDate = 0;
        try {
            firstDate = first.getInt("date");
            secondDate = second.getInt("date");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(firstDate == secondDate){
            return 0;
        }
        else{
            return (firstDate > secondDate) ? 1 : -1;
        }
    }
}