package com.kibo.order.data.repository.v1.dao_implementation;

import com.kibo.order.data.entity.entity.Post;
import com.kibo.order.data.repository.v1.dao.AbstractDao;
import com.kibo.order.data.repository.v1.dao.PostDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by marcus.chiu on 10/21/16.
 */
@Repository("postDao")
public class PostDaoImpl extends AbstractDao<Integer, Post> implements PostDao {

    @Override
    public Post findById(int post_id) {
        return getByKey(post_id);
    }

    @Override
    public void savePost(Post post) {
        persist(post);
    }

    @Override
    public void deletePostById(int post_id) {
        Query query = getSession().createSQLQuery("delete from Post where post_id = :post_id");
        query.setInteger("post_id", post_id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Post> findAllPosts() {
        Criteria criteria = createEntityCriteria();
        return (List<Post>) criteria.list();
    }
}
