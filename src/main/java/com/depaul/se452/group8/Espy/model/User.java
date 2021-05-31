package com.depaul.se452.group8.Espy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(nullable = false, unique = true, name = "username")
    private String username;

    @NotEmpty
    @Column(name = "password")
    private String password;

    @NotEmpty
    @Column(name = "plainPassword")
    private String plainPassword;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mobile")
    private String mobile;

    private String bio;

    @Lob
    @Column(name = "avatar_img_base_64")
    @Type(type = "org.hibernate.type.TextType")
    private String avatarImgBase64;

    @Column(name = "address")
    private String address;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comments> allComments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Images> allImages = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Friends> allFriends = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorites> allFavorites = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DirectMessages> allDirectMessages = new ArrayList<>();
}
