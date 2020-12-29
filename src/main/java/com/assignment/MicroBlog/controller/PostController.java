package com.assignment.MicroBlog.controller;

import com.assignment.MicroBlog.entity.Post;
import com.assignment.MicroBlog.ServiceImplementation.PostServiceImplementation;
import com.assignment.MicroBlog.model.PostForm;
import com.assignment.MicroBlog.response.PostResponse;
import com.assignment.MicroBlog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostServiceImplementation postService) {
        this.postService = postService;
    }


    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPost();
    }

    @GetMapping("/{id}")
    public PostResponse getPostById(@PathVariable Integer id){
        return postService.getPostById(id);
    }


//    @PostMapping("/{userId}")
//    public PostResponse createPost(@RequestBody PostForm post, @PathVariable Integer userId){
//        return postService.savePost(post ,userId);
//    }
}
