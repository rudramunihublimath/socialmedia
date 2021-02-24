package com.io.socialmedia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Followers {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private Integer postId;
}
