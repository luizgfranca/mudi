package com.study.mudi.controller;

import com.study.mudi.model.Request;
import com.study.mudi.model.RequestStatus;
import com.study.mudi.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping
    public String home(Model model, Principal principal) {

        List<Request> requests = requestRepository
                .findByStatus(
                        RequestStatus.DELIVERED,
                        PageRequest.of(
                                0,
                                10,
                                Sort.by("deliverDate").descending()
                        )
                );

        model.addAttribute("orders", requests);

        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {

        return "redirect:/home";

    }

}
