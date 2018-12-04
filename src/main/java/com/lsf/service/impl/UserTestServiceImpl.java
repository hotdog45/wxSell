package com.lsf.service.impl;

import com.lsf.dataObject.UserTest;
import com.lsf.repository.UserTestRepository;
import com.lsf.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTestServiceImpl implements UserTestService {

    @Autowired
    private UserTestRepository repository;

    @Override
    public UserTest findUserByMobile(String mobile) {
        return repository.findOne(mobile);
    }

    @Override
    public UserTest save(UserTest userTest) {
        return repository.save(userTest);
    }
}
