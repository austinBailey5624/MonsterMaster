package com.greenwolfgames.monstermaster;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NatureRepository extends JpaRepository<Nature, Integer> {
    // You can add custom query methods if needed
}