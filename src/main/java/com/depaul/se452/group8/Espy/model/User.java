package com.depaul.se452.group8.Espy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String bio;

    private String avatar;

    private Date createdAt;

    private Date updatedAt;
}
