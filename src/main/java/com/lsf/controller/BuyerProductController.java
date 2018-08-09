package com.lsf.controller;

import com.lsf.VO.ProductInfoVO;
import com.lsf.VO.ProductVO;
import com.lsf.VO.ResultVO;
import com.lsf.dataObject.ProductCategory;
import com.lsf.dataObject.ProductInfo;
import com.lsf.service.CategoryService;
import com.lsf.service.ProductService;
import com.lsf.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lishunfeng on 2018/8/8.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")
    public ResultVO list(){
        //1.查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.查询类目(一次性查询)
        List<Integer> categoryTyoeList = new ArrayList<>();
        //传统方法
//        for (ProductInfo productInfo :productInfoList){
//            categoryTyoeList.add(productInfo.getCategoryType());
//        }
        //精简方法(java8 lambda)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e ->e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList =  categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }




}
