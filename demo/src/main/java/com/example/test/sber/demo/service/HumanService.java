package com.example.test.sber.demo.service;

import com.example.test.sber.demo.entity.Human;

import java.util.List;

public interface HumanService {
    void save(Human human);
    List<Human> getAllHumans();
    void delete(int id);
    Human getHuman(int id);
}
