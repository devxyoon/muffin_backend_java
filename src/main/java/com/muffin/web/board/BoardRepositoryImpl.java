package com.muffin.web.board;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

interface IBoardRepository {

}

@Repository
public class BoardRepositoryImpl extends QuerydslRepositorySupport implements IBoardRepository {

    private final JPAQueryFactory queryFactory;
    private final DataSource dataSource;


    public BoardRepositoryImpl(JPAQueryFactory queryFactory, DataSource dataSource) {
        super(Board.class);
        this.queryFactory = queryFactory;
        this.dataSource = dataSource;
    }
}
