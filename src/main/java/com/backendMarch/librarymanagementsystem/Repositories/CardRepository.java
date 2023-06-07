package com.backendMarch.librarymanagementsystem.Repositories;


import com.backendMarch.librarymanagementsystem.Entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
}
