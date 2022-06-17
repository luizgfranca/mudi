package com.study.mudi.api;

import com.study.mudi.model.Request;
import com.study.mudi.model.RequestStatus;
import com.study.mudi.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestsAPI {

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping("waiting")
    public List<Request> getRequestsWaitingOffers() {
        return this.requestRepository.findByStatus(
                RequestStatus.WAITING,
                PageRequest.of(
                        0,
                        10,
                        Sort.by("id").descending()
                )
        );
    }

}
