package com.lsf;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lishunfeng on 2018/7/20.
 */

@Entity
//@Data
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer age;

    private String cupSize;

    public Girl() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }
}
