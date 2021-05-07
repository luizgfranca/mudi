package com.study.mudi.controller;

import com.study.mudi.dto.NewRequestDto;
import com.study.mudi.model.Request;
import com.study.mudi.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("request")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping("form")
    public String form() {

        return "request/form";

    }

    @PostMapping("new")
    public String add(NewRequestDto req) {

        Request request =  req.toRequest();
        requestRepository.save(request);

        return "request/form";

    }

}
