package com.lsf;

import com.lsf.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lishunfeng on 2018/7/22.
 */
@RestController
public class GirlController {


    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();

    }

    @PostMapping(value = "/girls")
    public Girl addGirl(@RequestParam("cupSize") String cupSize,
                        @RequestParam("name") String name,
                        @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setName(name);
        girl.setAge(age);

        return girlRepository.save(girl);

    }


    /**
     * 查询一个女生
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlDes(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }
    /**
     * 通过年龄查询一个女生列表
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlFindByAge(@PathVariable("age") Integer age) {
        return  girlRepository.findByAge(age);
    }

    /**
     * 更新一个女生列表
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("name") String name,
                           @RequestParam("age") Integer age) {

        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setName(name);
        girl.setAge(age);
        girl.setId(id);
        return girlRepository.save(girl);
    }

    /**
     * 删除一个女生列表
     */
    @DeleteMapping(value = "/girls/{id}")
    public String girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
        return "删除成功";
    }



    @PostMapping(value = "/girls/two")
    public String addTwoGirl(){
        girlService.insertTwo();
        return "成功";
    }

















}
