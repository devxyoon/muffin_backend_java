package com.muffin.web.user;

import com.muffin.web.board.Board;
import com.muffin.web.comment.Comment;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
@Table(name="user")
public class User {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userid")
    private String userid;
    @Column(name = "password")
    private String password;
    @Column(name="nickname")
    private String nickname;
    @Column(name="name")
    private String name;

    @Override
    public String toString() {
        return String.format("User[userid=%s, password='%s', name='%s', nickname='%s]", userid, password, name, nickname);
    }

    @Builder
    private User(String userid, String password, String nickname, String name) {
        this.userid = userid;
        this.password = password;
        this.nickname = nickname;
        this.name = name;
    }
}