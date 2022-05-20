package com.example.herokuappdemo.DAO;

import com.example.herokuappdemo.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntityDAO extends JpaRepository<ProductEntity,Long> {
}
