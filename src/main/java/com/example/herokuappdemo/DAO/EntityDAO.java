package com.example.herokuappdemo.DAO;

import com.example.herokuappdemo.Entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityDAO extends JpaRepository<ClassEntity,Long> {
}
