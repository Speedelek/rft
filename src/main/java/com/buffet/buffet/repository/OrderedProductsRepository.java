package com.buffet.buffet.repository;

import com.buffet.buffet.entities.OrderedProductsEntity;
import com.buffet.buffet.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.List;

@Repository
public interface OrderedProductsRepository extends CrudRepository<OrderedProductsEntity, Long> {

    List<OrderedProductsEntity> findAll();

    @Transactional
    @Modifying
    @Query(value = "insert into database1.ordered_products values (:orderId, :userId, :buffetId, :productId, :quantity, :takeouttime, :orderDate, :orderTime, :username)",nativeQuery = true)
    void insertByUser(@Param("orderId") Integer orderId,
                      @Param("userId") Integer userId,
                      @Param("buffetId") Integer buffetId,
                      @Param("productId") Integer productId,
                      @Param("quantity") Integer quantity,
                      @Param("takeouttime") Integer takeouttime,
                      @Param("orderDate") String orderDate,
                      @Param("orderTime") String orderTime,
                      @Param("username") String username);


    @Query(value = "select order_id from database1.ordered_products order by order_id desc limit 1", nativeQuery = true)
    Integer findLastOrder();

    @Query(value = "select db from database1.bufe_termek where bufe_id = :buffetIdInt and termek_id = :productIdInt", nativeQuery = true)
    Integer getOrderedItemQuantiy(@Param("buffetIdInt") Integer buffetIdInt,@Param("productIdInt") Integer productIdInt);


    @Modifying
    @Query(value = "update database1.bufe_termek set db = :orderedItemQuantity where bufe_id = :buffetIdInt and termek_id = :productIdInt" , nativeQuery = true)
    void decreaceQuantity(@Param("buffetIdInt") Integer buffetIdInt,@Param("productIdInt") Integer productIdInt, @Param("orderedItemQuantity") Integer orderedItemQuantity);

   /* @Transactional
    @Modifying
    @Query(value = "update database1.bufe_termek set termek_id = productIdIn")
    void decreaseProductQuantity(Integer buffetIdInt, Integer productIdInt);*/
}
