package com.example.StockmarketUpdate.Subject;

import com.example.StockmarketUpdate.Observer.Stockobserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class StockData implements Stocksubject{
    private ArrayList<Stockobserver> so;
    private String stockName;
    private float stockPrice;

    private boolean stockChanged=false;

    private Map<String, Float> sharePriceMap;

    public StockData(){
        so= new ArrayList<>();
        sharePriceMap= new HashMap<>();
    }

    @Override
    public void regsiterSubscriber(Stockobserver sto) {
        so.add(sto);

    }

    @Override
    public void removeSubscriber(Stockobserver sto) {
        int index=so.indexOf(sto);

        if(index>=0){
            so.remove(index);
        }
    }

    @Override
    public void notifyAllSubscribers() {
        for(Stockobserver sto:so){
            sto.update(stockName,sharePriceMap.get(stockName));
        }

    }

    public void stocksUpdated(){
        notifyAllSubscribers();
    }

    public void setStockData(String stockName, float stockPrice){
        this.stockName=stockName;
        this.stockPrice=stockPrice;
        if(!sharePriceMap.containsKey(stockName)){
            sharePriceMap.put(stockName,stockPrice);
            stockChanged=true;
        }else if(sharePriceMap.get(stockName)!=stockPrice){
            sharePriceMap.put(stockName,stockPrice);
            stockChanged=true;
        }
        if(stockChanged) {
            notifyAllSubscribers();
            stockChanged=false;
        }
    }
}
