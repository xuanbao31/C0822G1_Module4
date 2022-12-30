package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * " +
            "from blog " +
            "where name like concat('%', :name,'%')",nativeQuery = true)
    List<Blog> searchByName(@Param("name") String name);


    @Query(value = "select * " +
            "from blog " +
            "where name like concat('%', :name,'%')", nativeQuery = true)
    Page<Blog> findAuthor(@Param("name") String name,
                          Pageable pageable);
}
