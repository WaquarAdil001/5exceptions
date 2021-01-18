package com.waquar.testing.controller;



import com.waquar.testing.model.User;
import com.waquar.testing.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private UserRepository customerRepository;
    @Autowired
    private com.waquar.testing.repository.ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public User placeOrder(@RequestBody com.waquar.testing.dto.OrderRequest request){
       return customerRepository.save(request.getUser());
    }

    @GetMapping("/findAllOrders")
    public List<User> findAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<com.waquar.testing.dto.OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
    }
}
