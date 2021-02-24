package com.io.socialmedia.repository;

import com.io.socialmedia.entity.Followers;
import com.io.socialmedia.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface FollowersRepository extends JpaRepository<Followers, Serializable> {

    Followers findByUserIdAndPostId(Integer userId, Integer postId);


}
