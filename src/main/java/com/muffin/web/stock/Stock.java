package com.muffin.web.stock;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id") private Long stockId;
    @Column(name = "symbol") private int symbol;
    @Column(name = "market") private String market;
    @Column(name = "stock_name") private String stockName;
    @Column(name = "category_code") private int categoryCode;
    @Column(name = "category") private String category;
    @Column(name = "listed_shares") private String listedShares;

    @Builder
    public Stock(Long stockId, int symbol, String market, String stockName, int categoryCode, String category, String listedShares) {
        this.stockId = stockId;
        this.symbol = symbol;
        this.market = market;
        this.stockName = stockName;
        this.categoryCode = categoryCode;
        this.category = category;
        this.listedShares = listedShares;
    }
}
