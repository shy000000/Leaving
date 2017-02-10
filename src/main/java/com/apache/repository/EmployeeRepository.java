package com.apache.repository;

import com.apache.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shy on 2016/9/2.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer>{
    EmployeeEntity findByEmployId(String employid);
    List<EmployeeEntity> findByName(String name);
    List<EmployeeEntity> findBySectionId(String sectionId);
    List<EmployeeEntity> findByLevel(String level);
}
