package com.foodieapp.paymentGateWay.repository;

import com.foodieapp.paymentGateWay.domain.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyOrderRepository extends JpaRepository<MyOrder,Long> {

}
