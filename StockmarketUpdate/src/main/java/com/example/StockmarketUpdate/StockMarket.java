package com.example.StockmarketUpdate;

import com.example.StockmarketUpdate.Subject.StockData;
import com.example.StockmarketUpdate.Subscriber.StocksSubscriber;
import org.springframework.cache.support.NullValue;

import java.util.Scanner;

public class StockMarket {

    public static void main(String[] args) {
        StockData st= new StockData();
        StocksSubscriber stocksSubscriber= new StocksSubscriber(st);
        Scanner scn= new Scanner(System.in);

        try {
            System.out.println("Enter the total number of inputs you want");
            int totalInputs = scn.nextInt();
            for(int i=0;i<totalInputs;i++){
                System.out.println("Enter the stock name:");
                String name=scn.next();
                System.out.println("Enter the stock price");
                float price= scn.nextFloat();
                st.setStockData(name,price);
                //st.removeSubscriber(stocksSubscriber);
            }

        }catch(Exception e){
            System.out.println("Invalid input"+" "+e);
        }


        //st.setStockData("Adani", 30);
        //st.removeSubscriber(stocksSubscriber);
        //st.setStockData("Adani", 30);
        //st.setStockData(name,price);

    }
}
