package com.github.wesleyav.dslist.repositories;

import com.github.wesleyav.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}