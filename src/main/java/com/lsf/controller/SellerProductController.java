package com.lsf.controller;

import com.lsf.dataObject.ProductCategory;
import com.lsf.dataObject.ProductInfo;
import com.lsf.dto.OrderDTO;
import com.lsf.enums.PayStatusEnum;
import com.lsf.enums.ProductStatusEnum;
import com.lsf.enums.ResultEnum;
import com.lsf.exception.SellException;
import com.lsf.form.ProductFrom;
import com.lsf.service.CategoryService;
import com.lsf.service.OrderService;
import com.lsf.service.ProductService;
import com.lsf.utils.KeyUtil;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by lishunfeng on 2018/8/20.
 */
@Api(tags = "订单中心")
@Controller
@RequestMapping("/seller/product")
@Slf4j
public class SellerProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 订单列表
     *
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "订单列表",notes = "查询订单列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "分页", required = false,dataType = "Integer",allowMultiple = false),
            @ApiImplicitParam(name = "size", value = "数量", required = false)}
    )

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "3") Integer size,
                             Map<String, Object> map) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("product/list");

    }

    @GetMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productid") String productid,
                               Map<String, Object> map) {

        try {
            productService.onSale(productid);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", "");
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productid") String productid,
                                Map<String, Object> map) {

        try {
            productService.offSale(productid);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", "");
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }


    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productid", required = false) String productid,
                              Map<String, Object> map) {

        if (!StringUtils.isEmpty(productid)) {
            ProductInfo productInfo = productService.findOne(productid);
            map.put("productInfo", productInfo);
        }

        //查询所有的类目
        List<ProductCategory> categoryList = categoryService.findeAll();

        map.put("categoryList", categoryList);
        return new ModelAndView("product/index", map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid ProductFrom form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        ProductInfo productInfo = new ProductInfo();
        try {
            //如果productId为空, 说明是新增
            if (!StringUtils.isEmpty(form.getProductId())) {
                productInfo = productService.findOne(form.getProductId());
            } else {
                form.setProductId(KeyUtil.genUniqueKey());

            }
            BeanUtils.copyProperties(form, productInfo);

            productService.save(productInfo);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }


}
