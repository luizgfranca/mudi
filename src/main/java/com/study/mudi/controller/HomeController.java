package com.study.mudi.controller;

import com.study.mudi.model.Request;
import com.study.mudi.model.RequestStatus;
import com.study.mudi.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping
    public String home(Model model) {

        List<Request> requests = requestRepository.findAll();

        model.addAttribute("orders", requests);

        return "home";
    }

    @GetMapping("/{status}")
    public String homeByStatus(
            @PathVariable("status") String status,
            Model model
    ) {

        List<Request> requests = requestRepository.findByStatus(
                RequestStatus.valueOf(status.toUpperCase())
        );

        model.addAttribute("orders", requests);
        model.addAttribute("status", status);

        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {

        return "redirect:/home";

    }

}
