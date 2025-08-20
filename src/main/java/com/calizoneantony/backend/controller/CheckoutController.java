package com.calizoneantony.backend.controller;

import com.calizoneantony.backend.dto.OrderRequest;
import com.calizoneantony.backend.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    @Autowired
    CheckoutService checkoutService;

    @PostMapping("/purchase")
    public ResponseEntity<Void> placeOrder(@RequestBody OrderRequest orderRequest) {

        this.checkoutService.placeOrder(orderRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
