package com.lsf.repository;

import com.lsf.dataObject.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTest {

    @Autowired
    private UserInfoRepository repository;

    @Test
    public void findOneTest(){
        UserInfo result =  repository.findOne("1");
        System.out.println(result.toString());
    }

    @Test
    public void saveTest() {
        UserInfo userTest = new UserInfo();
        userTest.setAvatar("test");
        userTest.setMobile("15829554591");
        userTest.setPassword("123");
        userTest.setUsername("ergou");
        userTest.setId("2");

        UserInfo result = repository.save(userTest);
        Assert.assertNotNull(result);
    }
}