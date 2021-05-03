package com.study.mudi.controller;

import com.study.mudi.model.Request;
import com.study.mudi.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping("/home")
    public String home(Model model) {

        List<Request> requests = requestRepository.queryAllRequests();

        model.addAttribute("orders", requests);

        return "home";
    }

}
