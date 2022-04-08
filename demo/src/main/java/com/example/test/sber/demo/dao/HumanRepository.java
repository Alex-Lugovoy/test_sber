package com.example.test.sber.demo.dao;

import com.example.test.sber.demo.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanRepository extends JpaRepository<Human, Integer> {

}
