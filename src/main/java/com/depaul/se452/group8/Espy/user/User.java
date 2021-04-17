package com.depaul.se452.group8.Espy.user;

import lombok.Data;
import java.io.Serializable;
import java.sql.Date;

@Data
public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String bio;

    private String avatar;

    private Date createdAt;

    private Date UpdatedAt;
}
