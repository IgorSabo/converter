package com.unusual.repository;

import com.unusual.model.Gig;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Created by Igor on 4/22/2020.
 */
public interface GigRepository extends CrudRepository<Gig, Long> {

    @Query(value = "select g from Gig g where g.gigDate BETWEEN :startDate AND :endDate")
    Gig getGigForToday(@Param("startDate")Date startDate,@Param("endDate")Date endDate);
}
