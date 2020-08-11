package com.muffin.web.asset;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAsset is a Querydsl query type for Asset
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAsset extends EntityPathBase<Asset> {

    private static final long serialVersionUID = 1513681252L;

    public static final QAsset asset = new QAsset("asset");

    public final NumberPath<Integer> assetId = createNumber("assetId", Integer.class);

    public final NumberPath<Integer> priceEarnigsRatio = createNumber("priceEarnigsRatio", Integer.class);

    public final NumberPath<Integer> profitLoss = createNumber("profitLoss", Integer.class);

    public final NumberPath<Integer> shareCount = createNumber("shareCount", Integer.class);

    public final NumberPath<Integer> totalAsset = createNumber("totalAsset", Integer.class);

    public final DateTimePath<java.util.Date> transactionDate = createDateTime("transactionDate", java.util.Date.class);

    public final BooleanPath transactionType = createBoolean("transactionType");

    public QAsset(String variable) {
        super(Asset.class, forVariable(variable));
    }

    public QAsset(Path<? extends Asset> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAsset(PathMetadata metadata) {
        super(Asset.class, metadata);
    }

}

