package com.assignment.MicroBlog.controller;

import com.assignment.MicroBlog.entity.Comment;
import com.assignment.MicroBlog.entity.User;
import com.assignment.MicroBlog.model.PostForm;
import com.assignment.MicroBlog.repository.UserRepository;
import com.assignment.MicroBlog.response.PostResponse;
import com.assignment.MicroBlog.service.PostService;
import com.assignment.MicroBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;
    private final PostService postService;
    private final UserRepository userRepository;
    @Autowired
    public UserController(UserService userService , PostService postService , UserRepository userRepository) {
        this.userService = userService;
        this.postService = postService;
        this.userRepository = userRepository;
    }

    // TODO-- 1. User can create new posts
    @PostMapping("/{userId}/createPost")
    public PostResponse createPost(@RequestBody PostForm post, @PathVariable Integer userId){
        return postService.savePost(post ,userId);
    }

    // TODO-- 2. User can view posts of other users
    @GetMapping("/viewOtherPosts/{userId}")
    public List<PostResponse> viewOthersPosts(@PathVariable Integer userId){
        return userService.viewOthersPosts(userId);
    }

    // TODO-- 3.  User can comment  on posts of other posts
    @PostMapping("addCommentOnPost/{postId}")
    public void addCommentOnOtherPost(@RequestBody Comment comment, @PathVariable Integer postId){
        userService.addCommentOnOtherPost(comment,postId);
    }

    // TODO-- 4. User can upvote / downvote posts of other users.
    @PostMapping("/{userId}/upvoteForAPost/{postId}")
    public void upvoteParticularPost(@PathVariable Integer userId,@PathVariable Integer postId){
        userService.upvoteParticularPost(userId,postId);
    }
    @PostMapping("{userId}/downVoteForAPost/{postId}")
    public void downVoteParticularPost(@PathVariable Integer userId,@PathVariable Integer postId){
        userService.downVoteParticularPost(userId,postId);
    }


    // TODO-- 5. User can view comments of a particular post
    // TODO-- 6. User can see upvote and downvote counts of a particular post
    @GetMapping("viewCommentsOfOtherPosts/{title}")
    public List<Comment> viewCommentOnParticularPost(@PathVariable String title){
     return userService.viewAllCommentOfParticularPost(title);
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("viewParticularPost/{title}")
    public PostResponse getPostById(@PathVariable String title){
        return postService.getPostByTitle(title);
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
}
