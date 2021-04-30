package com.depaul.se452.group8.Espy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
public class Tags implements Serializable {
    private Integer id;

    private Integer imageId;

    private String tag;

    private Date createdAt;

    private Date updatedAt;
}
