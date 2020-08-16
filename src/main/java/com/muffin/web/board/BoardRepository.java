package com.muffin.web.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, IBoardRepository {
    Page<Board> findByIdGreaterThan(Long id, Pageable paging);
}
