package com.study.mudi.controller;

import com.study.mudi.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {

        Order order = new Order();
        order.setName("Kindle 10a. geração");
        order.setImgUrl("https://images-na.ssl-images-amazon.com/images/I/61X0ISBpD-L._AC_SL1000_.jpg");
        order.setProductUrl("https://www.amazon.com.br/dp/B07FQK1TS9?pf_rd_r=GHMPVK69CGYDNRWE03QG&pf_rd_p=e6761015-e49a-4ed6-8536-03c9db3b480b&pd_rd_r=65258577-8087-49ff-b0e0-c4845be95dc8&pd_rd_w=Nbaab&pd_rd_wg=7vcRb&ref_=pd_gw_unk");
        order.setDescription("Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia. O Kindle possui uma tela touchscreen antirreflexo, até mesmo sob o sol. É como se você estivesse lendo em papel.");
        order.setValue(new BigDecimal("284.05"));

        List<Order> orders = Arrays.asList(order);

        model.addAttribute("orders", orders);

        return "home";
    }

}
