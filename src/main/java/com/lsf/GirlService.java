package com.lsf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by lishunfeng on 2018/7/22.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;


    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setName("alis");
        girlA.setCupSize("AA");
        girlA.setAge(12);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setName("Boy");
        girlB.setCupSize("hhaaaaaaaa");
        girlB.setAge(44);
        girlRepository.save(girlB);

    }
}
