package com.muffin.web.board;

import com.muffin.web.comment.Comment;
import com.muffin.web.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
@Table(name="board")
public class Board {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "board_title")
    private String boardTitle;
    @Column(name="board_content")
    private String boardContent;
    @Column(name="board_regdate")
    private String boardRegdate;

    @Override
    public String toString() {
        return String.format("Board[boardTitle=%s, boardContent='%s', boardRegdate='%s']", boardTitle, boardContent, boardRegdate);
    }

    @Builder
    public Board(String boardTitle, String boardContent, String boardRegdate) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardRegdate = boardRegdate;
    }

    @ManyToOne @JoinColumn(name="user_id")
    private User user;

    @OneToMany @JoinColumn(name="comment_id")
    private List<Comment> commentList;

}
