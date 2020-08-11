package com.muffin.web.asset;

import com.muffin.web.board.Board;
import com.muffin.web.stock.Stock;
import com.muffin.web.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "asset")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asset_id") private int assetId;
    @Column(name = "total_asset") private int totalAsset;
    @Column(name = "transaction_date") private Date transactionDate;
    @Column(name = "price_earnings_ratio") private int priceEarnigsRatio;
    @Column(name = "profit_loss") private int profitLoss;
    @Column(name = "share_count") private int shareCount;
    @Column(name = "transaction_type") private boolean transactionType;

    @Builder
    public Asset(int assetId, int totalAsset, Date transactionDate, int priceEarnigsRatio, int profitLoss, int shareCount, boolean transactionType) {
        this.assetId = assetId;
        this.totalAsset = totalAsset;
        this.transactionDate = transactionDate;
        this.priceEarnigsRatio = priceEarnigsRatio;
        this.profitLoss = profitLoss;
        this.shareCount = shareCount;
        this.transactionType = transactionType;
    }

    @ManyToOne @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "asset", cascade = CascadeType.ALL)
    private List<Stock> stockList;

}
