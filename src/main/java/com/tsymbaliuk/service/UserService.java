package com.tsymbaliuk.service;

import com.tsymbaliuk.entity.Blog;
import com.tsymbaliuk.entity.Item;
import com.tsymbaliuk.entity.User;
import com.tsymbaliuk.repository.BlogRepository;
import com.tsymbaliuk.repository.ItemRepository;
import com.tsymbaliuk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Цымбалюк Сергей on 07.06.2016.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ItemRepository itemRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findOne(int id) {
        return userRepository.findOne(id);
    }

    @Transactional
    public User findOneWithBlogs(int id) {
        User user = findOne(id);
        List<Blog> blogs = blogRepository.findByUser(user);
        for(Blog blog:blogs){
            List<Item> items = itemRepository.findByBlog(blog,new PageRequest(0,10, Sort.Direction.DESC, "publishedDate"));
            blog.setItems(items);
        }
        user.setBlogs(blogs);
        return user;
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
