package com.tsymbaliuk.repository;

import com.tsymbaliuk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Цымбалюк Сергей on 03.06.2016.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
