package com.learning.demo.service;

import com.learning.demo.repo.LaptopRepository;
import com.learning.demo.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    public void addlaptop(Laptop laptop) {
        laptopRepository.save(laptop);
    }

    public boolean isGoodForPerson(Laptop laptop) {
        return true;
    }
}
