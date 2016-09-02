package com.apache.repository;

import com.apache.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shy on 2016/9/2.
 */
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
