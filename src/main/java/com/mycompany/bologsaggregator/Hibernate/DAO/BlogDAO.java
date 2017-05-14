package com.mycompany.bologsaggregator.Hibernate.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.bologsaggregator.Hibernate.Entity.Blog;
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

//    @SuppressWarnings("unchecked")
//    public List<Blog> getAllBlogs(String blogName) {
//        String query = "SELECT e.* FROM asd e WHERE e.name like '%" + blogName + "%'";
//        List<Object[]> blogObjects = hibernateUtil.fetchAll(query);
//        List<Blog> blogs = new ArrayList<Blog>();
//        for (Object[] blogObject : blogObjects) {
//            Blog blog = new Blog();
//            long id = ((BigInteger) blogObject[0]).longValue();
//            int age = (int) blogObject[1];
//            String name = (String) blogObject[2];
//            float salary = (float) blogObject[3];
//            blog.setBlog_dbid((int) id);
//            blog.setBlogName(name);
//
//            blogs.add(blog);
//        }
//        System.out.println(blogs);
//        return blogs;
//    }
}
