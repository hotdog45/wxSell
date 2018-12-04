package com.lsf.repository;

import com.lsf.dataObject.OrderMaster;
import com.lsf.dataObject.UserTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestRepositoryTest {

    @Autowired
    private UserTestRepository repository;

    @Test
    public void findOneTest(){
        UserTest result =  repository.findOne("2");
        System.out.println(result.toString());
    }

    @Test
    public void saveTest() {
        UserTest userTest = new UserTest();
//        userTest.setAvatar("test");
//        userTest.setMobile("15829554591");
//        userTest.setPassword("123");
        userTest.setUsername("金毛mao");
        userTest.setId("4");

        UserTest result = repository.save(userTest);
        Assert.assertNotNull(result);
    }


}