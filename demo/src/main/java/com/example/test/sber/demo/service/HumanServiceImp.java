package com.example.test.sber.demo.service;

import com.example.test.sber.demo.dao.HumanRepository;
import com.example.test.sber.demo.entity.Human;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumanServiceImp implements HumanService{

    @Autowired
    private HumanRepository humanRepository;

    @Override
    public void save(Human human) {
        humanRepository.save(human);
    }

    @Override
    public List<Human> getAllHumans() {
        return humanRepository.findAll();
    }

    @Override
    public void delete(int id) {
        humanRepository.deleteById(id);
    }

    @Override
    public Human getHuman(int id) {
        return humanRepository.getById(id);
    }
}