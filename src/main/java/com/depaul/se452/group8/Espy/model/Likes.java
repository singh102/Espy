package com.depaul.se452.group8.Espy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "likes")
public class Likes implements Serializable {
    private static Integer currentLikes = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "image_id")
    private Integer imageId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id", referencedColumnName = "id", nullable = false, unique = true, insertable = false, updatable = false)
    private Images image;

//    public Integer incrementLikes(Integer imageId) {
//        return currentLikes += 1;
//    }
//
//    public Integer getLikes(Integer imageId) {
//        return currentLikes;
//    }
}
