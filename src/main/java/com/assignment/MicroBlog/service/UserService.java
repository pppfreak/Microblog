package com.assignment.MicroBlog.service;


import com.assignment.MicroBlog.entity.Comment;
import com.assignment.MicroBlog.entity.User;
import com.assignment.MicroBlog.response.PostResponse;

import java.util.List;

public interface UserService {
    User getUserById(Integer integer);
    User saveUser(User user);
    List<PostResponse> viewOthersPosts(Integer userId);
    void upvoteParticularPost(Integer userId,Integer postId);
    void downVoteParticularPost(Integer userId,Integer postId);
    PostResponse addCommentOnOtherPost(Comment comment, Integer postId);
    List<Comment> viewAllCommentOfParticularPost(String title);
    void deleteComment(Integer commentId);
}
