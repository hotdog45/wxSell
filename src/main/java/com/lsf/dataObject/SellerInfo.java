package com.lsf.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by lishunfeng on 2018/8/24.
 */
@Data
@Entity
public class SellerInfo {




    @Id
    private String id;

    private String username;

    private String password;

    private String openid;

}
