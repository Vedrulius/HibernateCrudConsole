package com.mihey.hibernateconsole.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Transient
    private List<Post> post;
    @OneToOne(targetEntity = Region.class/*, cascade = CascadeType.ALL*/)
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private Region region;
    @Transient
    private Role role;

    public User() {
    }

    public User(String firstName, String lastName, Region region) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.region = region;
    }
}
