package com.kibo.order.service.service;

import com.kibo.order.data.entity.entity.Post;

import java.util.List;

/**
 * Created by marcus.chiu on 10/21/16.
 */
public interface PostService {
    Post findById(int post_id);

    void savePost(Post post);

    void updatePost(Post post);

    void deletePostById(int post_id);

    List<Post> findAllPosts();
}
