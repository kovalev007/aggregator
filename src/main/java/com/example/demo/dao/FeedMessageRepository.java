package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.FeedMessage;

@Repository
public interface FeedMessageRepository extends CrudRepository<FeedMessage, Long> {

    @Query("select fm from FeedMessage fm where upper(fm.title) like upper(concat('%', :title, '%')) order by fm.date desc")
    List<FeedMessage> findByTitle(@Param("title") String title);

}