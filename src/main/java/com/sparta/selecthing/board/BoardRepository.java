package com.sparta.selecthing.board;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BoardRepository extends JpaRepository<Board, Long> {
}
