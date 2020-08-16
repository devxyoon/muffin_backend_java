package com.muffin.web.board;

import com.muffin.web.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/boards")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/recentBoard")
    public Page<Board> recentBoard() {
        return boardService.recentBoard();
    }

    @GetMapping("/csv")
    public void csvRead() {
        boardService.readCsv();
    }

    @PostMapping("/insert")
    public void insert(@RequestBody BoardVO board) {
        boardService.save(board);
    }

    @GetMapping("/findAll")
    public Iterable<Board> findAll(){
        return boardService.findAll();
    }

    @GetMapping("/findOne/{id}")
    public Optional<Board> findOne(@PathVariable Long id) {
        return boardService.findById(id);
    }

    @GetMapping("/search/{searchword}/{condition}")
    public Iterable<Board> search(@PathVariable String searchword, String condition) {
        return boardService.findBySearchword(searchword, condition);
    }

    @PostMapping("/myBoard")
    public Iterable<Board> myBoasrd(@RequestBody User user) {
        return boardService.findByUserId(user.getId());
    }

    @PostMapping("/update")
    public Optional<Board> update(@RequestBody BoardVO board) {
        return boardService.update(board);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        boardService.delete(boardService.findById(id).get());
    }
}
