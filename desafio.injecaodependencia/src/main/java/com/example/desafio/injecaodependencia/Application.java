package com.example.desafio.injecaodependencia;

import com.example.desafio.injecaodependencia.entity.Order;
import com.example.desafio.injecaodependencia.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application  implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Order order = new Order(1032, 150.00, 20.00);
        System.out.println("Pedido código: " + order.getCode() );
        System.out.printf("Valor total: %.2f" , orderService.total(order));

     }
}
