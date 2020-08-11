package com.muffin.web.comment;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

interface ICommentRepository {

}

@Repository
public class CommentRepositoryImpl extends QuerydslRepositorySupport implements ICommentRepository {

    private final JPAQueryFactory queryFactory;
    private final DataSource dataSource;

    public CommentRepositoryImpl(JPAQueryFactory queryFactory, DataSource dataSource) {
        super(Comment.class);
        this.queryFactory = queryFactory;
        this.dataSource = dataSource;
    }
}
