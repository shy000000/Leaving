package com.apache.repository;

import com.apache.model.LeaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shy on 2016/9/2.
 */
public interface LeaveRepository extends JpaRepository<LeaveEntity,Integer>{
}
