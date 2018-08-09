package com.lsf;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Created by lishunfeng on 2018/7/20.
 */

@RestController
//@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "/say/{id}",method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id){
        return "hello spring boot id :" +id;
    }


    @RequestMapping(value = "/{id}/say",method = RequestMethod.GET)
    public String say2(@PathVariable("id") Integer id){
        return "hello spring boot id :" +id;
    }

    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String say3(@PathParam("id") Integer id){
        return " id :" +id;
    }

    @RequestMapping(value = "/say2",method = RequestMethod.GET)
    public String say4(@RequestParam(value = "id", required = false , defaultValue = "0") Integer myid){
        return " id4 :" + myid;
    }

//    @RequestMapping(value = "/say2",method = RequestMethod.GET)\
    @GetMapping(value = "/say3")
    public String say5(@RequestParam(value = "id", required = false , defaultValue = "0") Integer myid){
        return " id4 :" + myid;
    }








}
