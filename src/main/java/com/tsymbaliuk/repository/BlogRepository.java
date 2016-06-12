package com.tsymbaliuk.repository;

import com.tsymbaliuk.entity.Blog;
import com.tsymbaliuk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Цымбалюк Сергей on 03.06.2016.
 */
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByUser(User user);
}
