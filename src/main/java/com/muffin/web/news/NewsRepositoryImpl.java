package com.muffin.web.news;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

interface INewsRepository {

}

@Repository
public class NewsRepositoryImpl extends QuerydslRepositorySupport implements INewsRepository {

    private final JPAQueryFactory queryFactory;
    private final DataSource dataSource;


    public NewsRepositoryImpl(JPAQueryFactory queryFactory, DataSource dataSource) {
        super(News.class);
        this.queryFactory = queryFactory;
        this.dataSource = dataSource;
    }
}
