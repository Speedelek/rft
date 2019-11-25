package com.buffet.buffet.service;

import com.buffet.buffet.repository.OrderedProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderedProductsService {

    private OrderedProductsRepository orderedProductsRepository;

    @Autowired
    public void setOrderedProductsRepository(OrderedProductsRepository orderedProductsRepository){
        this.orderedProductsRepository = orderedProductsRepository;
    }

    @Transactional
    public void saveProductOrder(Integer orderId, Integer userId, Integer buffetIdInt, Integer productIdInt, Integer quantity, Integer takeoverTime) {
        orderedProductsRepository.insertByUser(orderId, userId, buffetIdInt, productIdInt, quantity, takeoverTime);
    }

    public Integer getLastOrderId(){ return orderedProductsRepository.findLastOrder();}

    public Integer getOrderedItemQuantiy(Integer buffetIdInt, Integer productIdInt) {
        return orderedProductsRepository.getOrderedItemQuantiy(buffetIdInt, productIdInt);
    }

    @Transactional
    public void decreaseOrderedItemQuantity(Integer buffetIdInt, Integer productIdInt, Integer orderedItemQuantity) {
        orderedProductsRepository.decreaceQuantity(buffetIdInt, productIdInt, orderedItemQuantity);
    }

    /*@Transactional
    public void decreaseProductQuantity(Integer buffetIdInt, Integer productIdInt) {
        orderedProductsRepository.decreaseProductQuantity(buffetIdInt, productIdInt);
    }*/
}
