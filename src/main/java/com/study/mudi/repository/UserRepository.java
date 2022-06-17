package com.study.mudi.repository;

import com.study.mudi.model.Request;
import com.study.mudi.model.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Request, Long> {

    List<Request> findByStatus(RequestStatus waiting);

    @Query("select r " +
            "from Request r " +
            "join r.user u " +
            "where u.username = :username")
    List<Request> findByUser(
            @Param("username")
            String username
    );
}
