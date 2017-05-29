package com.kibo.order.service.interfaces;

import com.kibo.order.data.entity.entity.Post;

import java.util.List;

/**
 * Created by marcus.chiu on 10/21/16.
 */
public interface IPostService {
    Post findById(int post_id);

    void savePost(Post post);

    void updatePost(Post post);

    void deletePostById(int post_id);

    List<Post> findAllPosts();
}
