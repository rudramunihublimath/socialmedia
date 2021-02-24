package com.io.socialmedia.repository;

import com.io.socialmedia.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Serializable> {

    //@Query(value = "select * from post_dtls s where s.USERS_USER_ID = ?1", nativeQuery = true)
    String sql = "select p.* from user_dtls u left join followers f on (u.user_id=f.user_id) left join post_dtls p on (p.post_Id=f.post_Id) " +
            "where f.user_id = ?1 ORDER BY  p.last_updated_at DESC";

    @Query(value = sql, nativeQuery = true)
    List<Post> findByUsers(Integer user_id);

}
