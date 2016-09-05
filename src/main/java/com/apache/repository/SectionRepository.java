package com.apache.repository;

import com.apache.model.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shy on 2016/9/2.
 */
@Repository
public interface SectionRepository extends JpaRepository<SectionEntity,Integer>{

}