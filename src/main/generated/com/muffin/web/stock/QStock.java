package com.muffin.web.stock;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStock is a Querydsl query type for Stock
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStock extends EntityPathBase<Stock> {

    private static final long serialVersionUID = -894905040L;

    public static final QStock stock = new QStock("stock");

    public final StringPath category = createString("category");

    public final NumberPath<Integer> categoryCode = createNumber("categoryCode", Integer.class);

    public final StringPath listedShares = createString("listedShares");

    public final StringPath market = createString("market");

    public final NumberPath<Long> stockId = createNumber("stockId", Long.class);

    public final StringPath stockName = createString("stockName");

    public final NumberPath<Integer> symbol = createNumber("symbol", Integer.class);

    public QStock(String variable) {
        super(Stock.class, forVariable(variable));
    }

    public QStock(Path<? extends Stock> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStock(PathMetadata metadata) {
        super(Stock.class, metadata);
    }

}

