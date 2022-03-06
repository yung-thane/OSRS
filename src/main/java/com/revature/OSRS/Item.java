package com.revature.OSRS;

public class Item {
    private int itemId;
    private String itemName;
    private int buyAverage;
    private int sellAverage;
    private int profitAverage;

    public Item(){

    }

    public Item(int itemId, String itemName, int buyAverage, int sellAverage) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.buyAverage = buyAverage;
        this.sellAverage = sellAverage;
        this.profitAverage = sellAverage-buyAverage;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getBuyAverage() {
        return buyAverage;
    }

    public void setBuyAverage(int buyAverage) {
        this.buyAverage = buyAverage;
    }

    public int getSellAverage() {
        return sellAverage;
    }

    public void setSellAverage(int sellAverage) {
        this.sellAverage = sellAverage;
    }

    public int getProfitAverage() {
        return profitAverage;
    }

    public void setProfitAverage(int profitAverage) {
        this.profitAverage = profitAverage;
    }

    @Override
    public String toString() {
        return "Item {" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", buyAverage=" + buyAverage +
                ", sellAverage=" + sellAverage +
                ", profitAverage=" + profitAverage +
                '}';
    }
}
