package com.lsf.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UserInfo {



    @Id
    private String id;

    private String username;

    private String password;

    private String avatar;

    private Integer age;

    private String address;

    private Integer level;

    private String mobile;

    private String token;

}
