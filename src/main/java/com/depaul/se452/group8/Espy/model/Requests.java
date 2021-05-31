package com.depaul.se452.group8.Espy.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, unique = true, insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id", referencedColumnName = "id", nullable = false, unique = true, insertable = false, updatable = false)

    private User friend;
    public void addRequest(Integer friendId) {
        reqs.add(friendId);
    }
    public Iterable<Integer> getRequest() {
        return reqs;
    }
}
