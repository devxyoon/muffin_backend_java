package com.muffin.web.board;

import com.muffin.web.user.User;
import com.muffin.web.util.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/boards")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BoardController {

    private final BoardService boardService;
    private final Pagination pagination;

    public BoardController(BoardService boardService, Pagination pagination) {
        this.boardService = boardService;
        this.pagination = pagination;
    }

    @GetMapping("/pagination/{page}/{range}")
    public Map<?,?> pagination(@PathVariable int page, @PathVariable int range) {
        pagination.pageInfo(page, range, boardService.count());
        Map<String, Object> box = new HashMap<>();
        box.put("pagination", pagination);
        box.put("list", boardService.pagination(pagination));
        return box;
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
    public Iterable<Board> myBoard(@RequestBody User user) {
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
