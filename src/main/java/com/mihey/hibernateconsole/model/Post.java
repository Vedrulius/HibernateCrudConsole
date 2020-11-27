package com.mihey.hibernateconsole.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "userid")
    private Integer userId;
    @Column(name = "content")
    private String content;
    @Column(name = "created")
    private Timestamp created;
    @Column(name = "updated")
    private Timestamp updated;

    public Post() {
    }

    public Post(Integer userId, String content) {
        this.userId = userId;
        this.content = content;
    }
}
