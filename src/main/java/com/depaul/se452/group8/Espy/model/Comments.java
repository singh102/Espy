package com.depaul.se452.group8.Espy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
public class Comments implements Serializable {
    Integer id;

    Integer imageId;

    Integer userId;

    String comment;

    Date createdAt;

    Date updatedAt;
}
