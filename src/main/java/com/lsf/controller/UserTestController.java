package com.lsf.controller;

import com.lsf.VO.ResultVO;
import com.lsf.converter.OrderFrom2OrderDTOConverter;
import com.lsf.dataObject.UserTest;
import com.lsf.dto.OrderDTO;
import com.lsf.enums.ResultEnum;
import com.lsf.exception.SellException;
import com.lsf.form.OrderFrom;
import com.lsf.service.BuyerService;
import com.lsf.service.OrderService;
import com.lsf.service.UserTestService;
import com.lsf.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "用户接口")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserTestController {

    @Autowired
    private UserTestService userTestService;


    //创建订单@Valid UserTest userTest,
    @ApiOperation(value = "查询字段")
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@RequestBody UserTest userTest2) {
        UserTest result = userTestService.save(userTest2);
        return ResultVOUtil.success(result);


    }
}
