package com.study.mudi.repository;

import com.study.mudi.model.Request;
import com.study.mudi.model.RequestStatus;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    @Cacheable("status-requests")
    List<Request> findByStatus(RequestStatus waiting, Pageable pageable);

    @Query("select r " +
            "from Request r " +
            "join r.user u " +
            "where u.username = :username"
    )
    List<Request> findByUser(
            @Param("username")
            String username
    );

    @Query("select r " +
            "from Request r " +
            "join r.user u " +
            "where u.username = :username" +
            "      and r.status = :status"
    )
    List<Request> findByUserAndStatus(
            @Param("username")
            String username,

            @Param("status")
            RequestStatus status
    );
}
