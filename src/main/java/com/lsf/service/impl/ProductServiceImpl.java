package com.lsf.service.impl;

import com.lsf.dataObject.ProductInfo;
import com.lsf.dto.CartDTO;
import com.lsf.dto.OrderDTO;
import com.lsf.enums.ProductStatusEnum;
import com.lsf.enums.ResultEnum;
import com.lsf.exception.SellException;
import com.lsf.repository.ProductInfoRepository;
import com.lsf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lishunfeng on 2018/8/8.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {


    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0 ){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStatus(result);

            repository.save(productInfo);

        }
    }
}
