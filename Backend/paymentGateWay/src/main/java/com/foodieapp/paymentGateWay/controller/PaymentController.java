package com.foodieapp.paymentGateWay.controller;

import com.foodieapp.paymentGateWay.domain.MyOrder;
import com.foodieapp.paymentGateWay.repository.MyOrderRepository;
import com.foodieapp.paymentGateWay.service.EmailService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@Controller
@CrossOrigin("http://localhost:4200")
@RequestMapping("/payment")
public class PaymentController {


    private MyOrderRepository myOrderRepository;
    private EmailService emailService;

    @Autowired
    public PaymentController(MyOrderRepository myOrderRepository,
                             EmailService emailService){
        this.myOrderRepository=myOrderRepository;
        this.emailService=emailService;

    }

    @PostMapping("/create_order/{email}")
    @ResponseBody
    public String createOrder(@RequestBody Map<String,Object> data,@PathVariable String email){
        System.out.println(data);

        int amount=Integer.parseInt(data.get("amount").toString());

        RazorpayClient client= null;
        try {
            client = new RazorpayClient("rzp_test_LP91fzOg59Pohi","H1ohtNvYEEO8YxskcB02URs1");
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("amount",amount*100);
        jsonObject.put("currency","INR");
        jsonObject.put("receipt","txt_23456");

        Order order = null;
        try {
            order = client.orders.create(jsonObject);
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
        System.out.println(order);

        MyOrder myOrder=new MyOrder();

        myOrder.setAmount(order.get("amount")+"");
        myOrder.setOrderId(order.get("id"));
        myOrder.setPaymentId(null);
        myOrder.setStatus("created");
        myOrder.setReceipt(order.get("receipt"));
         myOrderRepository.save(myOrder);
        boolean sendEmail = emailService.sendEmail(email,amount);

        return order.toString();
    }

}
