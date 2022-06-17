package com.study.mudi.controller;

import com.study.mudi.dto.NewRequestDto;
import com.study.mudi.model.Request;
import com.study.mudi.model.User;
import com.study.mudi.repository.RequestRepository;
import com.study.mudi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("request")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("form")
    public String form(NewRequestDto req) {

        return "request/form";

    }

    @PostMapping("new")
    public String add(@Valid NewRequestDto req, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "request/form";
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);

        Request request =  req.toRequest();
        request.setUser(user);

        requestRepository.save(request);

        return "redirect:/home";

    }

}
