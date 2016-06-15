package com.tsymbaliuk.service;

import com.tsymbaliuk.entity.Blog;
import com.tsymbaliuk.entity.Item;
import com.tsymbaliuk.entity.User;
import com.tsymbaliuk.repository.BlogRepository;
import com.tsymbaliuk.repository.ItemRepository;
import com.tsymbaliuk.repository.UserRepository;
import exeption.RssExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Цымбалюк Сергей on 12.06.2016.
 */
@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RssService rssService;

    @Autowired
    private ItemRepository itemRepository;

    public void saveItems(Blog blog){
        try {
            List<Item> items =rssService.getItems(blog.getUrl());
            for(Item item:items){
                Item savedItem=itemRepository.findByBlogAndLink(blog, item.getLink());
                if(savedItem==null) {
                    item.setBlog(blog);
                    itemRepository.save(item);
                }
            }
        } catch (RssExeption rssExeption) {
            rssExeption.printStackTrace();
        }
    }

    @Scheduled(fixedDelay=360000)
    public void reloadBlogs(){
        List<Blog> blogs = blogRepository.findAll();
        for(Blog blog: blogs){
            saveItems(blog);
        }
    }

    public void save(Blog blog, String name){
        User user = userRepository.findByName(name);
        blog.setUser(user);
        blogRepository.save(blog);
        saveItems(blog);
    }
    @PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
    public void delete(@P("blog") Blog blog) {
        blogRepository.delete(blog);
    }

    public Blog findOne(int id) {
        return blogRepository.findOne(id);
    }
}
