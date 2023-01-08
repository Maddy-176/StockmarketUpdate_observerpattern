package com.example.StockmarketUpdate.Subject;

import com.example.StockmarketUpdate.Observer.Stockobserver;

public interface Stocksubject {
    void regsiterSubscriber(Stockobserver so);

    void removeSubscriber(Stockobserver so);

    void notifyAllSubscribers();
}
