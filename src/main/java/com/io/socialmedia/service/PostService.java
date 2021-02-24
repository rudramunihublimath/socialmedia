package com.io.socialmedia.service;

import com.io.socialmedia.entity.Followers;
import com.io.socialmedia.entity.Post;
import com.io.socialmedia.entity.User;
import com.io.socialmedia.repository.FollowersRepository;
import com.io.socialmedia.repository.PostRepository;
import com.io.socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostService {

    private PostRepository postRepository;

    private UserRepository userRepository;

    private FollowersRepository followersRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository, FollowersRepository followersRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.followersRepository = followersRepository;
    }

    public String createPostservice(Post post) {
        postRepository.save(post);
        return "Post created";
    }


    public int follow(Followers followers) {
        if (followers.getUserId() == followers.getPostId())
            return 2; //same person and follower
        Followers byId = followersRepository.findByUserIdAndPostId( followers.getUserId(),  followers.getPostId());
        if(byId!=null)
            return 0;
        else{
            Followers flr = followersRepository.save(followers);
            return 1;
        }

    }

    public int unfollow(Followers followers) {
        if (followers.getUserId() == followers.getPostId())
            return 2; //same person and follower
        Followers byId = followersRepository.findByUserIdAndPostId( followers.getUserId(),  followers.getPostId());
        if(byId!=null) {
            followersRepository.deleteById(byId.getId());
            return 1;
            }
        else{
            return 0;
        }
    }

    public List<Integer> followers(Integer user_id) {
        List<Post> byUsers = postRepository.findByUsers(user_id);
        List<Integer> arr = new ArrayList<>();
        byUsers.stream().limit(20).forEach(
                i-> arr.add(i.getPost_id())
        );
        return arr;
    }


    public User createUsertservice(User user) {
        return userRepository.save(user);
    }
}
