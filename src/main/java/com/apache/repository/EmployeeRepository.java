package com.apache.repository;

import com.apache.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shy on 2016/9/2.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer>{
}
