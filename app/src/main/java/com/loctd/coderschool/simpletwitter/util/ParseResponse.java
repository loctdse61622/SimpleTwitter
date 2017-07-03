package com.loctd.coderschool.simpletwitter.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loctd.coderschool.simpletwitter.model.Tweet;
import com.loctd.coderschool.simpletwitter.model.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class ParseResponse {
    static Gson gson = new Gson();
    public static List<Tweet> getTweetFromResp(JSONArray response){
        List<Tweet> tweets = gson.fromJson(response.toString(),
                new TypeToken<List<Tweet>>() {
                }.getType());

        return tweets;
    }

    public static User getCurrentUserFromResp(JSONObject response){
        User currentUser = gson.fromJson(response.toString(),
                new TypeToken<User>(){}.getType());
        return currentUser;
    }
    public static Tweet getTweetFromResponse(JSONObject response){
        Tweet tweet = gson.fromJson(response.toString(),
                new TypeToken<Tweet>(){}.getType());

        return tweet;
    }
}
