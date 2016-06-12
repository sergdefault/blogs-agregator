package com.tsymbaliuk.service;

import com.tsymbaliuk.entity.Blog;
import com.tsymbaliuk.entity.User;
import com.tsymbaliuk.repository.BlogRepository;
import com.tsymbaliuk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Цымбалюк Сергей on 12.06.2016.
 */
@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    public void save(Blog blog, String name){
        User user = userRepository.findByName(name);
        blog.setUser(user);
        blogRepository.save(blog);
    }
}
