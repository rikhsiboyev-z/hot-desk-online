package com.example.hotdesk.order;

import com.example.hotdesk.common.repository.GenericSpecificationRepository;
import com.example.hotdesk.order.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends GenericSpecificationRepository<Order,Integer> {
}
