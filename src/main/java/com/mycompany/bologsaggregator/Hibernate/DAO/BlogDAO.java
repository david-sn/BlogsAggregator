package com.mycompany.bologsaggregator.Hibernate.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.bologsaggregator.Hibernate.Entity.Blog;
import com.mycompany.bologsaggregator.Hibernate.Entity.User;
import com.mycompany.bologsaggregator.Hibernate.Session.NewHibernateUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service
@Repository
public class BlogDAO {

    public BlogDAO() {
        System.out.println("Blog-DAO-`Impl");
    }

    @Autowired
    private NewHibernateUtil hibernateUtil;

    public int createBlog(Blog blog) {
        return (int) hibernateUtil.create(blog);
    }
    public int createBlog(Blog blog,String name) {
        User user=getUsersByName(name).get(0);
        blog.setUser(user);
        
        return (int) hibernateUtil.create(blog);
    }

    public Blog updateBlog(Blog blog) {
        return hibernateUtil.update(blog);
    }

    public void deleteBlog(int id) {
        Blog blog = new Blog();
        blog.setBlog_dbid(id);
        hibernateUtil.delete(blog);
    }

    public List<Blog> getAllBlogs() {
        return hibernateUtil.fetchAll(Blog.class);
    }

    public Blog getBlog(int id) {
        return hibernateUtil.fetchById(id, Blog.class);
    }

    @SuppressWarnings("unchecked")
    public List<User> getUsersByName(String UserName) {
        List<User> usersObjects = hibernateUtil.getByName("userName", UserName, User.class);
        return usersObjects;
    }
}
