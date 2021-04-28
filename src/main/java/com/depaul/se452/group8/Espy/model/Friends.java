package com.depaul.se452.group8.Espy.model;

import javax.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@Entity
public class Friends implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer friendId;

    private Date createdAt;

    private Date updatedAt;
}
