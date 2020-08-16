package com.muffin.web.board;

import com.muffin.web.user.UserRepository;
import com.muffin.web.util.GenericService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

interface BoardService extends GenericService<Board> {

    void readCsv();

    void save(BoardVO board);

    Optional<Board> update(BoardVO board);

    Iterable<Board> findBySearchword(String searchword, String condition);

    Iterable<Board> findByUserId(Long id);

    Page<Board> recentBoard();
}

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;
    private final UserRepository userRepository;

    public BoardServiceImpl(BoardRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Board> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Board> findAll() {
        return repository.findAll();
    }

    @Override
    public int count() {
        return (int)repository.count();
    }

    @Override
    public void delete(Board board) {
        repository.delete(board);
    }

    @Override
    public boolean exists(String id) {
        return repository.existsById(Long.parseLong(id));
    }

    @Override
    public void readCsv() {
        InputStream is = getClass().getResourceAsStream("/static/opinion.csv");
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for(CSVRecord csvRecord : csvRecords){
                repository.save(new Board(
                        csvRecord.get(1),
                        csvRecord.get(2),
                        csvRecord.get(3),
                        Integer.parseInt(csvRecord.get(4)),
                                userRepository.findById(Long.parseLong(csvRecord.get(5))+1).get(),
                                new ArrayList<>())
                         );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void save(BoardVO board) {
        Board b = new Board(board.getBoardTitle(), board.getBoardContent(), board.getBoardRegdate(), board.getViewCnt(), board.getUser(), new ArrayList<>());
        repository.save(b);
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

    @Override
    public Page<Board> recentBoard() {
        Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "id");
        Page<Board> list = repository.findByIdGreaterThan(0L, paging);
        list.forEach(System.out::println);
        return list;
    }
}
