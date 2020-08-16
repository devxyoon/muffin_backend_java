package com.muffin.web.board;

import com.muffin.web.util.GenericService;
import org.springframework.stereotype.Service;

import java.util.Optional;

interface BoardService extends GenericService<Board> {

    void readCsv();

    void save(BoardVO board);

    Optional<Board> update(BoardVO board);

    Iterable<Board> findBySearchword(String searchword, String condition);

    Iterable<Board> findByUserId(Long id);
}

@Service
public class BoardServiceImpl implements BoardService {

    @Override
    public Optional<Board> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<Board> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(Board board) {

    }

    @Override
    public boolean exists(String id) {
        return false;
    }

    @Override
    public void readCsv() {

    }

    @Override
    public void save(BoardVO board) {

    }

    @Override
    public Optional<Board> update(BoardVO board) {
        return Optional.empty();
    }

    @Override
    public Iterable<Board> findBySearchword(String searchword, String condition) {
        return null;
    }

    @Override
    public Iterable<Board> findByUserId(Long id) {
        return null;
    }
}
