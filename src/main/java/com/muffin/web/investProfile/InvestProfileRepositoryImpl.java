package com.muffin.web.investProfile;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.sql.DataSource;

interface IInvestProfileRepository {

}

public class InvestProfileRepositoryImpl extends QuerydslRepositorySupport implements IInvestProfileRepository {

    private final JPAQueryFactory queryFactory;
    private final DataSource dataSource;

    public InvestProfileRepositoryImpl(JPAQueryFactory queryFactory, DataSource dataSource) {
        super(InvestProfile.class);
        this.queryFactory = queryFactory;
        this.dataSource = dataSource;
    }
}
