package com.assignment.MicroBlog.repository;

import com.assignment.MicroBlog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
     Post findByTitle(String title);
}
