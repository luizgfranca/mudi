package com.study.mudi.repository;

import com.study.mudi.model.Request;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RequestRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Request> queryAllRequests() {

        Query query = entityManager.createQuery("SELECT r FROM Request r", Request.class);

        return query.getResultList();

    }

}
