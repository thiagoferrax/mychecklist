package com.company.mychecklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.mychecklist.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
