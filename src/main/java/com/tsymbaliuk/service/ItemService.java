package com.tsymbaliuk.service;

import com.tsymbaliuk.entity.Item;
import com.tsymbaliuk.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Цымбалюк Сергей on 15.06.2016.
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getItems(){
       return itemRepository.findAll(new PageRequest(0,20, Direction.DESC,"publishedDate")).getContent();
    }
}
