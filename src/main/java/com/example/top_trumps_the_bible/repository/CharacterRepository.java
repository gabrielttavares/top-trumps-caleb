package com.example.top_trumps_the_bible.repository;

import com.example.top_trumps_the_bible.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
}