package com.io.socialmedia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "USER_DTLS")
public class User {
    @Id
    @GeneratedValue
    private Integer user_id;
    private String name;
    //@OneToMany(mappedBy = "users")   // POST.users is referrred
    //private List<Post> post;
}
