package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select *" +
            " from blog" +
            " where name_book like concat('%', :nameBook,'%') and status=0 ", nativeQuery = true)
    Page<Blog> findAllByNameContaining(Pageable pageable,
                                       @Param("nameBook") String nameBook);
}
