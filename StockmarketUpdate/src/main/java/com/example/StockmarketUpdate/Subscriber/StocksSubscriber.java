package com.example.StockmarketUpdate.Subscriber;

import com.example.StockmarketUpdate.Observer.Stockobserver;
import com.example.StockmarketUpdate.Subject.StockData;

public class StocksSubscriber implements Stockobserver,Stockdisplay {
    private String stockName;
    private float stockPrice;

    public StocksSubscriber(StockData stockData){
        stockData.regsiterSubscriber(this);
    }
    @Override
    public void update(String stockName, float stockPrice) {
        this.stockName=stockName;
        this.stockPrice=stockPrice;
        display();
    }

    @Override
    public void display() {
        System.out.println("Alert: "+" "+stockName+": "+"Rs."+" "+stockPrice);
    }
}
