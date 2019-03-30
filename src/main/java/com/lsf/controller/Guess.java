package com.lsf.controller;

import com.lsf.VO.ResultVO;
import com.lsf.dataObject.UserTest;
import com.lsf.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Api(tags = "测试接口")
@RestController
public class Guess {



    //创建订单@Valid UserTest userTest,
    @GetMapping("/guess")
    public ResultVO<Map<String,String>> create() {
        return ResultVOUtil.success("100");
//        return ResultVOUtil.success("10");

    }
}
