package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.News;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {

    @Query("select fm from News fm where upper(fm.title) like upper(concat('%', :title, '%')) order by fm.date desc")
    List<News> findByTitle(@Param("title") String title);

}