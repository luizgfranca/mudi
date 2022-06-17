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

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping("/request")
    public String home(Model model, Principal principal) {

        List<Request> requests = requestRepository
                .findByUser(principal.getName());

        model.addAttribute("orders", requests);

        return "user/home";
    }

    @GetMapping("/request/{status}")
    public String userRequestsByStatus(
            @PathVariable("status") String status,
            Model model,
            Principal principal
    ) {

        List<Request> requests = requestRepository.findByUserAndStatus(
            principal.getName(), RequestStatus.valueOf(status)
        );

        model.addAttribute("orders", requests);
        model.addAttribute("status", status);

        return "user/home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {

        return "redirect:/user/request";

    }

}
