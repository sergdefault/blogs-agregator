package com.tsymbaliuk.repository;

import com.tsymbaliuk.entity.Blog;
import com.tsymbaliuk.entity.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Цымбалюк Сергей on 03.06.2016.
 */
public interface ItemRepository extends JpaRepository<Item,Integer> {
    List<Item> findByBlog(Blog blog, Pageable pageable);
}
