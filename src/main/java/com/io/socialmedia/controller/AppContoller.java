package com.io.socialmedia.controller;


import com.io.socialmedia.entity.Followers;
import com.io.socialmedia.entity.Post;
import com.io.socialmedia.entity.User;
import com.io.socialmedia.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppContoller {

    private PostService ts;

    public AppContoller(PostService ts) {
        this.ts = ts;
    }

    @RequestMapping(value = "/follow", method =  RequestMethod.PUT )
    public String follow(@RequestBody Followers followers) {
        int follow = ts.follow(followers);
        if (follow == 1)
            return "{\"status\": \"Success\", \"message\": \"You have followed the user successfully\"} ";
        else if (follow == 2)
            return "{\"status\": \"Error\", \"message\": \"You cannot follow yourself\"}";
        else if (follow == 0)
            return "{\"status\": \"Error\", \"message\": \"You already follow the user\"}";
        else
            return "{\"status\": \"Error\", \"message\": \"None\"}";
    }


    @RequestMapping(value = "/api/createpost", method = RequestMethod.POST )
    public String createPost(@RequestBody Post post) {
         return ts.createPostservice(post);
    }

    @RequestMapping(value = "/api/createuser", method = RequestMethod.POST )
    public User createuser(@RequestBody User user) {
        return ts.createUsertservice(user);
    }

    @RequestMapping(value = "/unfollow", method = RequestMethod.PUT)
    public String unfollow(@RequestBody Followers followers) {
        int unfollow = ts.unfollow(followers);
        if (unfollow == 1)
            return "{\"status\": \"Success\", \"message\": \"You have unfollowed the user successfully\"} ";
        else if (unfollow == 2)
            return "{\"status\": \"Error\", \"message\": \"You cannot unfollow yourself\"}";
        else if (unfollow == 0)
            return "{\"status\": \"Error\", \"message\": \"You need to follow the user to unfollow\"}";
        else
            return "{\"status\": \"Error\", \"message\": \"None\"}";
    }


    @RequestMapping(value = "/getnewsfeed", method = RequestMethod.GET)
    public List<Integer> getnewsfeed(@RequestParam(value="user_id") Integer user_id ) {
        return ts.followers(user_id);
    }

}
