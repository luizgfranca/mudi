package com.study.mudi.controller;

import com.study.mudi.dto.NewRequestDto;
import com.study.mudi.model.Request;
import com.study.mudi.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("request")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping("form")
    public String form(NewRequestDto req) {

        return "request/form";

    }

    @PostMapping("new")
    public String add(@Valid NewRequestDto req, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "request/form";
        }

        Request request =  req.toRequest();
        requestRepository.save(request);

        return "request/form";

    }

}
