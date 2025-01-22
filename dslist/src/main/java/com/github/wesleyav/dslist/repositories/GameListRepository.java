package com.github.wesleyav.dslist.repositories;

import com.github.wesleyav.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}