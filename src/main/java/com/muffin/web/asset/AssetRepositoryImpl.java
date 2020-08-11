package com.muffin.web.asset;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

interface IAssetRepository {

}

@Repository
public class AssetRepositoryImpl extends QuerydslRepositorySupport implements IAssetRepository {

    private final JPAQueryFactory queryFactory;
    private final DataSource dataSource;


    public AssetRepositoryImpl(JPAQueryFactory queryFactory, DataSource dataSource) {
        super(Asset.class);
        this.queryFactory = queryFactory;
        this.dataSource = dataSource;
    }
}
