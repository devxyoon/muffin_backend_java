package com.muffin.web.board;

import com.muffin.web.util.Pagination;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

interface IBoardRepository {

    List<Board> pagination(Pagination pagination);
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

    @Override
    public List<Board> pagination(Pagination pagination) {
        QBoard qb = QBoard.board;
        return queryFactory.selectFrom(qb).orderBy(qb.id.desc())
                .offset(pagination.getStartList()).limit(pagination.getListSize()).fetch();
    }
}
