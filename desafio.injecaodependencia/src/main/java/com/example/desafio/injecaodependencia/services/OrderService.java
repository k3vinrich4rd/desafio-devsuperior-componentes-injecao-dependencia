package com.example.desafio.injecaodependencia.services;

import com.example.desafio.injecaodependencia.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {

        double basicValue = order.getBasic();
        double discount = basicValue * (order.getDiscount() / 100);
        double frete = shippingService.shipment(order);
        return basicValue - discount + frete;




    }


}
