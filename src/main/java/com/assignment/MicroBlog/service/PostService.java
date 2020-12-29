package com.assignment.MicroBlog.service;


import com.assignment.MicroBlog.entity.Post;
import com.assignment.MicroBlog.model.PostForm;
import com.assignment.MicroBlog.response.PostResponse;

import java.util.List;

public interface PostService {
    List<Post> getAllPost();
    PostResponse getPostById(Integer id);
    PostResponse savePost(PostForm post, Integer userId);
    PostResponse getPostByTitle(String title);

}
