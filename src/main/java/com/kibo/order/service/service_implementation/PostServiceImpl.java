package com.kibo.order.service.service_implementation;

import com.kibo.order.service.service.PostService;
import com.kibo.order.data.entity.entity.Post;
import com.kibo.order.data.repository.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by marcus.chiu on 10/21/16.
 */
@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {

    //PostDaoImpl bean is used
    @Autowired
    private PostDao dao;

    @Override
    public Post findById(int post_id) {
        return dao.findById(post_id);
    }

    @Override
    public void savePost(Post post) {
        dao.savePost(post);
    }

    /**
     * Since the method is running with Transaction, no need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends
     * @param post
     */
    @Override
    public void updatePost(Post post) {
        Post entity = dao.findById(post.getId());

        if(entity != null) {
            entity.setText(post.getText());
        }
    }

    @Override
    public void deletePostById(int id) {
        dao.deletePostById(id);
    }

    @Override
    public List<Post> findAllPosts() {
        return dao.findAllPosts();
    }
}
