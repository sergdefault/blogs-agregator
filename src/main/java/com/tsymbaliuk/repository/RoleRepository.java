package com.tsymbaliuk.repository;


import com.tsymbaliuk.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Цымбалюк Сергей on 03.06.2016.
 */
public interface RoleRepository extends JpaRepository <Role,Integer>{
    Role findByName(String name);
}
