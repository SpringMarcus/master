package com.kibo.order.data.repository.v1.dao;

import com.kibo.order.data.entity.entity.Post;

import java.util.List;

/**
 * Created by marcus.chiu on 10/21/16.
 */
public interface PostDao {
    Post findById(int post_id);

    void savePost(Post post);

    void deletePostById(int post_id);

    List<Post> findAllPosts();
}
