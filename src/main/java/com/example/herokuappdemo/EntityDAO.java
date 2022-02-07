package com.example.herokuappdemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityDAO extends JpaRepository<ClassEntity,Long> {
}
