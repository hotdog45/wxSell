package com.lsf;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lishunfeng on 2018/7/22.
 */
//@Repository
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    public List<Girl> findByAge(Integer age);
}
