package com.apache.repository;

import com.apache.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shy on 2016/9/2.
 */
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer>{
}
