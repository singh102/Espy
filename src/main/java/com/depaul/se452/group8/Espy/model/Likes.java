package com.depaul.se452.group8.Espy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
public class Likes implements Serializable {
    private Integer id;

    private Integer imageId;

    private Integer userId;

    private String comment;

    private Date createdAt;

    private Date updatedAt;
}
