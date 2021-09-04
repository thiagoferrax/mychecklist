package com.company.mychecklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.mychecklist.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
