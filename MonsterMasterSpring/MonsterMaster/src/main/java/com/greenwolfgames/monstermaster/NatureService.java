package com.greenwolfgames.monstermaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NatureService {

    @Autowired
    private NatureRepository natureRepository;

    // Method to fetch all natures
    public List<Nature> getAllNatures() {
        return natureRepository.findAll();
    }
}