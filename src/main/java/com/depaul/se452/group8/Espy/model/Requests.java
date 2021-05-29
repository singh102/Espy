package com.depaul.se452.group8.Espy.model;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "requests")
public class Requests implements Serializable {
    private static Set<Integer> reqs = new HashSet<Integer>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "friend_id")
    private Integer friendId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public void addRequest(Integer friendId) {
        reqs.add(friendId);
    }
    public Iterable<Integer> getRequest() {
        return reqs;
    }
}
