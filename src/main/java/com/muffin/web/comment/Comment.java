package com.muffin.web.comment;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
@Table(name="comment")
public class Comment {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="comment_content")
    private String commentContent;

    @Column(name="commnet_regdate")
    private String commentRegdate;

    @Override
    public String toString() {
        return String.format("Comment[commentContent=%s, commentRegdate=%s]", commentContent, commentRegdate);
    }

    @Builder
    public Comment(String commentContent, String commentRegdate) {
        this.commentContent = commentContent;
        this.commentRegdate = commentRegdate;
    }
}
